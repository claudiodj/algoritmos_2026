package com.ejemplo.DAO;

import java.util.LinkedList;

import com.ejemplo.control.ConectarBase;
import com.ejemplo.modelo.Clientes;

public class ClientesDAO {

    public int insertarCliente(Clientes cliente) {
        // Implementación para insertar un cliente en la base de datos
        int idCliente = 0; // Aquí deberías generar o recuperar el ID del cliente insertado
        
        String sql = "INSERT INTO clientes (nombre, apellido, email, telefono, dni, fechaNacimiento) VALUES (?, ?, ?, ?, ?, ?)";
        try (var conexion = new ConectarBase().conectar();  
             var preparedStatement = conexion.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {
            
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellido());
            preparedStatement.setString(3, cliente.getEmail());
            preparedStatement.setString(4, cliente.getTelefono());
            preparedStatement.setInt(5, cliente.getDni());
            preparedStatement.setDate(6, java.sql.Date.valueOf(cliente.getFechaNacimiento()));
            
            int affectedRows = preparedStatement.executeUpdate();
            
            if (affectedRows > 0) {
                try (var generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        idCliente = generatedKeys.getInt(1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return idCliente; // Retorna el ID del cliente insertado
    }

    public static boolean borrarClientePorId(int idCliente) {
        String sql = "DELETE FROM clientes WHERE idCliente = ?";
        try (var conexion = new ConectarBase().conectar();  
             var preparedStatement = conexion.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, idCliente);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0; // Retorna true si se borró al menos un registro
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Retorna false en caso de error
        }
    }

    public LinkedList<Clientes> obtenerClientes() {
        LinkedList<Clientes> listaClientes = new LinkedList<>();
        String sql = "SELECT * FROM clientes";
        
        try (var conexion = new ConectarBase().conectar();  
             var statement = conexion.createStatement();  
             var resultSet = statement.executeQuery(sql)) {
            
            while (resultSet.next()) {
                Clientes cliente = new Clientes();
                cliente.setIdCliente(resultSet.getInt("idCliente"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setApellido(resultSet.getString("apellido"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setDni(resultSet.getInt("dni"));
                cliente.setFechaNacimiento(resultSet.getDate("fechaNacimiento").toLocalDate());
                
                listaClientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaClientes;
    }
}
