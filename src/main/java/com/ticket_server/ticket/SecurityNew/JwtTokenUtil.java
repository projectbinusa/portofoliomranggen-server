package com.ticket_server.ticket.SecurityNew;


import com.ticket_server.ticket.detail.AdminDetail;
import com.ticket_server.ticket.repository.AdminRepository;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class JwtTokenUtil implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);



    private String jwtSecret = "springboot";
    private int jwtExpirationMs = 604800000;

    private static final String SECRET_KEY = "springboot";

    @Autowired
    private AdminRepository userRepository;


    public static Claims decodeJwt(String jwtToken) {
        Jws<Claims> jwsClaims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(jwtToken);

        return jwsClaims.getBody();
    }


    public static long extractIssuedAt(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

        Date issuedAt = claims.getIssuedAt();
        return issuedAt.getTime();
    }

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("id", getUserIdFromUserDetails(userDetails))
                .claim("role", getRoleFromUserDetails(userDetails))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    private Long getUserIdFromUserDetails(UserDetails userDetails) {
        if  (userDetails instanceof AdminDetail) {
            return ((AdminDetail) userDetails).getId();
        }
        return null;
    }

    private String getRoleFromUserDetails(UserDetails userDetails) {
        if (userDetails instanceof AdminDetail) {
            return "USER";
        }
        return null;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }
}