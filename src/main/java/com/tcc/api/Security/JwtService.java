package com.tcc.api.Security;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {
    private static final String SECRET = "5Gsceo89urp5GZJf2zzxWhM2THxFiXBb1Uccbvq25bkNRhKzeWbT8GsmHbpAc3ep";
    private static final long EXPIRATION = 1000 * 60 * 60 * 8; // 8 horas

    private Key getSignKey() {
        return new SecretKeySpec(
                SECRET.getBytes(),
                SignatureAlgorithm.HS256.getJcaName()
        );
    }

    public String generateToken(Integer id, String role) {

        return Jwts.builder()
                .claim("id", id)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + EXPIRATION)
                )
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
