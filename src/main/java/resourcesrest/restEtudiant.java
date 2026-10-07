package resourcesrest;

import entities.Etudiant;
import metiers.EtudiantBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("etudiants")
public class restEtudiant {

    public static EtudiantBusiness etuB = new EtudiantBusiness();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEtudiant(Etudiant e) {
        if (etuB.addEtudiant(e)) {
            return Response.status(200).build();
        }else{
        return Response.status(404).build();}
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEtudiants(){
        List<Etudiant> l = etuB.getAllEtudiants();
        return Response.status(200).entity(l).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEtudiantById(@PathParam("id") String id){
        Etudiant e = etuB.getEtudiantByIdentifiant(id);

        if(e != null){
            return Response.status(200).entity(e).build();
        }
        else{
            return Response.status(404).build();
        }

}
    @DELETE
    @Path("{id}")
    public Response deleteEtudiant(@PathParam("id") String id){
        if(etuB.deleteEtudiant(id)){
            return Response.status(204).build();
        }
        else {
            return Response.status(404).build();
        }
    }
@PUT
@Path("{id}")
@Consumes(MediaType.APPLICATION_JSON)
    public Response updateEtudiant(@PathParam("id") String id, Etudiant e) {
        if(etuB.updateEtudiant(id, e)){
            return Response.status(200).build();
        }
        else{
            return Response.status(404).build();
        }
    }
}
