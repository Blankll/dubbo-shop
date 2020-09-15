package com.seven.dubbo.shop.gateway.controllers;

import com.seven.dubbo.shop.api.GoodService;
import com.seven.dubbo.shop.entities.Good;
import com.seven.dubbo.shop.gateway.builders.GoodBuilder;
import com.seven.dubbo.shop.gateway.services.SecurityUserDetailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author: Blank
 * @description: com.seven.dubbo.shop.gateway.controllers
 * @date: 9/6/20
 * @version: 1.0
 */

@ExtendWith(SpringExtension.class)
@WebMvcTest(GoodController.class)
public class GoodControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GoodService goodService;
    @MockBean
    private GoodController goodController;
    @MockBean
    private SecurityUserDetailService securityUserDetailService;

    @Test
    void shouldGetAllAvailableGoods() throws Exception {
        List<Good> goods = Collections.singletonList(new GoodBuilder().withId(1L).withName("IPhone").build());
        when(goodService.getAllAvailableGoods()).thenReturn(goods);
        goodController.setGoodService(goodService);
        mockMvc.perform(get("/goods")
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].name").value("IPhone"));
    }
}
