package com.karaoke.repository;


import com.karaoke.model.Chanson;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ChansonDAOImpl implements ChansonDAO {
    private final Connection connection;
    public ChansonDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public void insert(Chanson e) {
        String sql = "INSERT INTO chanson(title, dateCreationSong, gender, lyrics) values (?, ?, ?, ?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,e.getTitle());
            statement.setDate(2, Date.valueOf(e.getDateCreationSong()));
            statement.setString(3,e.getGender());
            statement.setString(4,e.getLyrics());

            statement.executeUpdate();
            System.out.println("insertion effectuer avec succes");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Chanson> findAll() {
        List<Chanson> chansons = new ArrayList<>();
        String sql = "SELECT * FROM chanson";

        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                chansons.add(new Chanson(
                        resultSet.getInt("id_chanson"),
                        resultSet.getString("title"),
                        resultSet.getDate("DateCreationSong").toLocalDate(),
                        resultSet.getString("gender"),
                        resultSet.getString("lyrics")
                ));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return chansons;
    }

    @Override
    public Chanson findById(int id) {
        String sql = "SELECT * FROM chanson WHERE id_chanson = ? ";

        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                return new Chanson(
                        resultSet.getInt("id_chanson"),
                        resultSet.getString("title"),
                        resultSet.getDate("DateCreationSong").toLocalDate(),
                        resultSet.getString("gender"),
                        resultSet.getString("lyrics")
                );
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void update ( Chanson e ) {
        String sql = "UPDATE Chanson SET title = ?, dateCreation = ?, gender = ?, lyrics = ? WHERE id_chanson = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,e.getTitle());
            statement.setDate(2, Date.valueOf(e.getDateCreationSong()));
            statement.setString(3,e.getGender());
            statement.setString(4,e.getLyrics());
            statement.setInt(5, e.getId_chanson());

        } catch (SQLException ex) {
            throw new RuntimeException("Erreur lors de la mis à jour");
        }
    }

    @Override
    public Chanson delete(int id) {
        Chanson chansondel = this.findById(id);
        if(chansondel == null)
            return  null;
        String sql = "DELETE FROM chanson WHERE id_chanson = " + id;
        try{
            connection.prepareStatement(sql).executeUpdate();
            return chansondel;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}


