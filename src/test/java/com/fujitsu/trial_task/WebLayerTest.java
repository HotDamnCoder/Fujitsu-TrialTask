package com.fujitsu.trial_task;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testWithoutParams() throws Exception {
        this.mockMvc.perform(get("/deliveryFee"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("is not present")));
    }

    @Test
    public void testWithOnlyLocation() throws Exception {
        String url = "/deliveryFee?location={location}";
        String location = "";

        this.mockMvc.perform(get(url, location))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString(
                        "Required request parameter 'vehicleType' for method parameter type String is not present")));
    }

    @Test
    public void testWithOnlyVehicle() throws Exception {
        String url = "/deliveryFee?vehicleType={vehicleType}";
        String vehicleType = "";
        this.mockMvc.perform(get(url, vehicleType))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString(
                        "Required request parameter 'location' for method parameter type String is not present")));
    }

    @Test
    public void testWrongLocation() throws Exception {
        String url = "/deliveryFee?location={location}&vehicleType={vehicleType}";
        String location = "Haapsalu";
        String vehicleType = "Car";

        this.mockMvc.perform(get(url, location, vehicleType))
                .andExpect(status().isNotFound())
                .andExpect(content()
                        .string(containsString("The required data for calculating delivery fee was not found")));
    }

    @Test
    public void testWrongVehicleType() throws Exception {
        String url = "/deliveryFee?location={location}&vehicleType={vehicleType}";
        String location = "Tallinn";
        String vehicleType = "Train";

        String resp = this.mockMvc.perform(get(url, location, vehicleType))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertTrue(resp.equals("{\"fee\":0.0}"));
    }

    @Test
    public void testLocationCaseSensitivity() throws Exception {
        String url = "/deliveryFee?location={location}&vehicleType={vehicleType}";
        String location = "Tallinn";
        String vehicleType = "Car";

        String resp1 = this.mockMvc.perform(get(url, location, vehicleType)).andExpect(status().isOk()).andReturn()
                .getResponse().getContentAsString();
        String resp2 = this.mockMvc.perform(get(url, location.toLowerCase(), vehicleType)).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        String resp3 = this.mockMvc.perform(get(url, location.toUpperCase(), vehicleType)).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertTrue(resp1.equals(resp2) && resp1.equals(resp3));

    }

    public void testVehiclyTypeCaseSensitivity() throws Exception {
        String url = "/deliveryFee?location={location}&vehicleType={vehicleType}";
        String location = "Tallinn";
        String vehicleType = "Car";

        String resp1 = this.mockMvc.perform(get(url, location, vehicleType)).andExpect(status().isOk()).andReturn()
                .getResponse().getContentAsString();
        String resp2 = this.mockMvc.perform(get(url, location, vehicleType.toLowerCase())).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        String resp3 = this.mockMvc.perform(get(url, location, vehicleType.toUpperCase())).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        assertTrue(resp1.equals(resp2) && resp1.equals(resp3));

    }

}
