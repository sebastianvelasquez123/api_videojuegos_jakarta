package com.sebastian;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Path("/juegos")
public class VideojuegoController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Videojuego> getJuegos() {
        List<Videojuego> lista = new ArrayList<>();
        String sql = "SELECT * FROM videojuegos";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Videojuego v = new Videojuego();
                v.setId(rs.getInt("id_juego"));
                v.setTitulo(rs.getString("titulo"));
                v.setPrecio(rs.getDouble("precio"));
                v.setIdCategoria(rs.getInt("id_categoria"));
                lista.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
