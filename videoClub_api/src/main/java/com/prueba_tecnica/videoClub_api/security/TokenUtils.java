package com.prueba_tecnica.videoClub_api.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class TokenUtils {
    private final static String ACCESS_TOKEN_SECRET = "cOfvwY9vtkAcbN8tD14TuDccTb4oLZLuVW7RuO=uXMf!sLKiJzr63dep9LEM8QyoSWEvVZ?5E7ISyOSHYkrLpq=hThr8WAGcGq3Uci6Et??lkz-1m40SIKn?!s/gwq/aW=omoqY0a34dAwKbCD2WKfK5lZ7sR9ij1qrKt0P5UlaBPTS4tD4RSAK7k9xxBQ?BlF2dkpIja=umHAPq=3/9XYKFGYBN/SkNP2Ot5IZn83tBI!w-d7J1WCogynMVbm0t";
    private final static Long ACCES_TOKEN_VALIDITY_SECONDS =  2_952_000L;

    public static String createToken(String nombre, String email){
        Long expirationTime = ACCES_TOKEN_VALIDITY_SECONDS * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", nombre);
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes(StandardCharsets.UTF_8)))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes(StandardCharsets.UTF_8))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();
            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        }catch (JwtException e){
            return null;
        }
    }
}
