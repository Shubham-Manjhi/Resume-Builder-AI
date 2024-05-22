package org.apple.com.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.apple.com.Entity.UserDetails;
import org.apple.com.service.Impl.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/action")
public class UserDetailsController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Operation(summary = "API to Fetch UserDetails")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Fetched UserDetails Successfully",
            content = {
                @Content(examples = {
                    @ExampleObject(summary = "Example 1",
                        name = "Example 1",
                        value = UserDetailsControllerConstants.USER_DETAILS)
                }, mediaType = "application/json",
                    schema = @Schema(implementation = UserDetails.class))
            }),
        @ApiResponse(responseCode = "401", description = "Unauthorised",
            content = @Content),
        @ApiResponse(responseCode = "404", description = "Not found",
            content = @Content)
    })
    @GetMapping("/user-details/{userId}")
    public UserDetails fetchUserDetails(@PathVariable("userId") long userId) {
        return userDetailsService.getUserDetails(userId);
    }

    @Operation(summary = "API to Create a UserDetails")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
        content = {@Content(examples =
            {@ExampleObject(summary = "Example 1", name = "Example 1",
                value = UserDetailsControllerConstants.USER_DETAILS)},
            mediaType = "application/json")})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Created a new UserDetails Successfully",
            content = {@Content(examples = {@ExampleObject(summary = "Example 1", name = "Example 1",
                value = UserDetailsControllerConstants.USER_DETAILS)}, mediaType = "application/json",
                schema = @Schema(implementation = UserDetails.class))}),
        @ApiResponse(responseCode = "401", description = "Unauthorised",
            content = @Content),
        @ApiResponse(responseCode = "404", description = "Not found",
            content = @Content)})
    @PostMapping("/user-details/save")
    public UserDetails createNewRule(@RequestBody UserDetails userDetails) {
        return userDetailsService.create(userDetails);
    }
}
