package com.example.co2.Controller;

import com.example.co2.Dao.RoleRepository;
import com.example.co2.Dao.UserRepository;
import com.example.co2.Entite.Role;
import com.example.co2.Entite.Userco2;
import com.example.co2.Service.MailSenderService;
import com.example.co2.Dto.RoleName;
import com.example.co2.jwt.JwtProvider;
import com.example.co2.jwt.JwtResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    MailSenderService mailSending;

    @PostMapping("/signIn")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestParam(name="username") String username, @RequestParam(name="password") String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username,password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }
    @RequestMapping(value = "/signup/employee", method = RequestMethod.POST)
    public ResponseEntity<Userco2> registerUser(@Validated @RequestBody Userco2 user1) {
        if (userRepository.existsByUsername(user1.getUsername())) {
            return new ResponseEntity<Userco2>(HttpStatus.NOT_FOUND);
        }
        if (userRepository.existsByEmail(user1.getEmail())) {
            return new ResponseEntity<Userco2>(HttpStatus.BAD_REQUEST);
        }
        Userco2 user = new Userco2(user1.getName(), user1.getUsername(), user1.getEmail(), passwordEncoder.encode(user1.getPassword()), false, user1.getAddress(), false);
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(RoleName.ROLE_Employee)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
        roles.add(userRole);
        user.setRoles(roles);
       // user.setValid(false);
        Userco2 suser = userRepository.save(user);
        if (suser != null) {
            String Newligne = System.getProperty("line.separator");
            String url = "http://localhost:4200/auth/verification/" + suser.getToken();
            String body = "Welcom to our platform \n  use this link to verify your account is :" + Newligne + url;
            try {
                mailSending.send(user.getEmail(), "Welcome", body);
                return new ResponseEntity<Userco2>(user, HttpStatus.OK);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

        @RequestMapping(value = "/signup/entreprise", method = RequestMethod.POST)
        public ResponseEntity<Userco2> registerEntreprise(@Validated @RequestBody Userco2 user1)   {
            if(userRepository.existsByUsername(user1.getUsername())) {
                return new ResponseEntity<Userco2>(HttpStatus.NOT_FOUND);
            }
            if(userRepository.existsByEmail(user1.getEmail())) {
                return new ResponseEntity<Userco2>(HttpStatus.BAD_REQUEST);
            }
            Userco2 user = new Userco2(user1.getName(),user1.getUsername(),user1.getEmail(),passwordEncoder.encode(user1.getPassword()),false,user1.getAddress(),false);
            Set<Role> roles = new HashSet<>();
            Role userRole = roleRepository.findByName(RoleName.ROLE_Entreprise)
                    .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
           roles.add(userRole);
            user.setRoles(roles);
         //   user.setValid(false);
            Userco2 suser= userRepository.save(user);
            if(suser != null ) {
                String Newligne = System.getProperty("line.separator");
                String url = "http://localhost:4200/auth/verification/" + suser.getToken();
                String body = "Welcom to our platform \n  use this link to verify your account is :" + Newligne + url;
                try {
                    mailSending.send(user.getEmail(), "Welcome", body);
                    return new ResponseEntity<Userco2>(user, HttpStatus.OK);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
                }
            }
            else
            {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }


    }}
















