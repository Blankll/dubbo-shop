package com.seven.dubbo.shop.gateway.aspects;

import com.seven.dubbo.shop.gateway.services.SecurityUserDetailService;
import com.seven.dubbo.shop.gateway.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Blank
 * @description: com.seven.dubbo.shop.gateway.aspects
 * @date: 8/23/20
 * @version: 1.0
 */
public class AuthenticateFilter extends OncePerRequestFilter {
    @Autowired
    private SecurityUserDetailService userDetailService;
    @Autowired
    private JWTUtil jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String token = request.getHeader("Authorization");
        if (SecurityContextHolder.getContext().getAuthentication() == null && jwtUtil.verifyToken(token)) {
                String username = jwtUtil.extractUsername(token);
                UserDetails userDetails = userDetailService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken autToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                autToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(autToken);
        }
        filterChain.doFilter(request, response);
    }
}
