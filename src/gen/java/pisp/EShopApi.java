package pisp;

import pisp.dto.*;
import pisp.EShopApiService;
import pisp.factories.EShopApiServiceFactory;

import io.swagger.annotations.ApiParam;

import pisp.dto.EShopRegistrationResponseDTO;
import pisp.dto.EShopProfileDTO;
import pisp.dto.LoginCredentialsDTO;

import java.util.List;

import java.io.InputStream;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/e-shop")


@io.swagger.annotations.Api(value = "/e-shop", description = "the e-shop API")
public class EShopApi  {

   private final EShopApiService delegate = EShopApiServiceFactory.getEShopApi();

    @POST
    @Path("/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add and register a new ecommerce site/ app", notes = "Admins of ecommerce sites/apps can register their sites/apps at pisp.", response = EShopRegistrationResponseDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "E-Shop successfully registered"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Required parameters missing"),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Username already exists"),
        
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "unexpected error in the server") })

    public Response addNewEshop(@ApiParam(value = "Chosen content type" ,required=true , allowableValues="{values=[application/json]}")@HeaderParam("Content-Type") String contentType,
    @ApiParam(value = "created new e-shop oject" ,required=true ) EShopProfileDTO body)
    {
    return delegate.addNewEshop(contentType,body);
    }
    @DELETE
    @Path("/{username}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete e-shop from pisp", notes = "This to ecommerce site/app admins to unregister their site from PISP.", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "E-shop successfully deleted"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Required parameters missing"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Authentication failed"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Username not found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Unexpected error in server") })

    public Response deleteEshop(@ApiParam(value = "The username that needs to be deleted",required=true ) @PathParam("username")  String username,
    @ApiParam(value = "The session id is set in the cookie" ,required=true , allowableValues="{values=[application/json]}")@HeaderParam("Cookie") String cookie)
    {
    return delegate.deleteEshop(username,cookie);
    }
    @POST
    @Path("/login")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "E-shop admins login to the PISP system", notes = "", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "User login successful"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Required parameters missing"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Authentication failed"),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Invalid password supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Username not found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Unexpected error in server") })

    public Response eshopLogin(@ApiParam(value = "Chosen content type" ,required=true , allowableValues="{values=[application/json]}")@HeaderParam("Content-Type") String contentType,
    @ApiParam(value = "login credentials of e-shop user" ,required=true ) LoginCredentialsDTO body)
    {
    return delegate.eshopLogin(contentType,body);
    }
    @GET
    @Path("/{username}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get e-shop profile details by username", notes = "Return requested e-shop profile Info", response = EShopProfileDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successfully retrieved the profile Information"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Required parameter missing"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Authentication failed"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Username not found") })

    public Response getEshopProfile(@ApiParam(value = "username of the e-shop to be fetched",required=true ) @PathParam("username")  String username,
    @ApiParam(value = "The session id is set in the cookie" ,required=true , allowableValues="{values=[application/json]}")@HeaderParam("Cookie") String cookie)
    {
    return delegate.getEshopProfile(username,cookie);
    }
    @PUT
    @Path("/{username}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update e-shop profile details", notes = "This is to ecommerce site/app admins to update their profile details.", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "E-shop profile successfully updated"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Required parameters missing"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Authentication failed"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Username not found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Unexpected error in server") })

    public Response updateProfile(@ApiParam(value = "username of the e-shop that need to be updated",required=true ) @PathParam("username")  String username,
    @ApiParam(value = "Chosen content type" ,required=true , allowableValues="{values=[application/json]}")@HeaderParam("Content-Type") String contentType,
    @ApiParam(value = "The session id is set in the cookie" ,required=true , allowableValues="{values=[application/json]}")@HeaderParam("Cookie") String cookie,
    @ApiParam(value = "Updated user object" ,required=true ) EShopProfileDTO body)
    {
    return delegate.updateProfile(username,contentType,cookie,body);
    }
}

