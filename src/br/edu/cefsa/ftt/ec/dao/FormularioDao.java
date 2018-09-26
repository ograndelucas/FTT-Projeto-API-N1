package br.edu.cefsa.ftt.ec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.edu.cefsa.ftt.ec.model.Formulario;
import br.edu.cefsa.ftt.util.DbUtil;

public class FormularioDao {

    private Connection connection;

    public FormularioDao() {
        connection = DbUtil.getConnection();
    } //FormularioDao

    public void addFormulario(Formulario formulario) {
        
    	try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO FORMULARIO (NOME, DATA, IDADE) VALUES (?, ?, ?)");
            
            // Parameters start with 1
            preparedStatement.setString(1, formulario.getNome());
            preparedStatement.setDate(2, new java.sql.Date(formulario.getData().getTime())); //java.sql.Date não tem time zone...
            preparedStatement.setFloat(3, formulario.getIdade());
            
            preparedStatement.executeUpdate();
            

        } catch (SQLException e) {
            e.printStackTrace();
            
            throw new ArithmeticException("FormularioDao: addFormulario: " + e.getMessage()); 
        }
    } 

    public void deletePeople(long id) {
        try {
            
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM FORMULARIO WHERE ID=?");
            
            // Parameters start with 1
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //deletePeople

    public void updateFormulario(Formulario formulario) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE FORMULARIO SET NOME=?, " 
                    		                          + "DATA=?, " 
                    		                          + "IDADE=? " 
                                               + "WHERE ID=?");
            
            // Parameters start with 1
            preparedStatement.setString(1, formulario.getNome());
            preparedStatement.setDate(2, (java.sql.Date)formulario.getData());
            preparedStatement.setFloat(3, formulario.getIdade());
            preparedStatement.setLong(4, people.getId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Formulario> getAllFormulario() {
        
    	List<Formulario> f = new ArrayList<Formulario>();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM FORMULARIO");
            while (rs.next()) {
                
            	Formulario formulario = new Formulario();
                
            	formulario.setId(rs.getLong("ID"));
                formulario.setNome(rs.getString("NOME"));
                formulario.setData(rs.getDate("DATA"));
                formulario.setIdade(rs.getFloat("IDADE"));
                f.add(formulario);
            }
        } catch (SQLException e) {
            f.printStackTrace();
        }

        return f;
    } 

    public Formulario getUserById(long id) {

    	Formulario f = new Formulario();
        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * from FORMULARIO WHERE ID=?");
            
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                f.setId(rs.getLong("ID"));
                f.setNome(rs.getString("NOME"));
                f.setData(rs.getDate("DATA"));
                f.setIdade(rs.getFloat("IDADE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return f;
    } 
    
}