package com.karaoke.repository;

import com.karaoke.model.Artist;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArtistDAOImpl implements ArtistDAO{
    private final Connection connection;
    public ArtistDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Artist e) {
        String sql = "INSERT INTO artist(name, lastName, genderArtist , birthday, deathDate) values (?, ?, ?, ?, ?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,e.getName());
            statement.setString(2,e.getLastName());
            statement.setString(3,e.getGenderArtist());
            statement.setDate(4, Date.valueOf(e.getBirthday()));
            statement.setDate(5, Date.valueOf(e.getDeathDate()));

            statement.executeUpdate();
            System.out.println("insertion effectuer avec succes");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Artist> findAll() {
        List<Artist> Artist = new ArrayList<>();
        String sql = "SELECT * FROM artist";

        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Artist.add(new Artist(
                        resultSet.getInt("id_artist"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getString("genderArtist"),
                        resultSet.getDate("birthday").toLocalDate(),
                        resultSet.getDate("deathDate").toLocalDate()
                ));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Artist;
    }

    @Override
    public Artist findById(int id) {
        String sql = "SELECT * FROM artist WHERE id_artist = ? ";

        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                return new Artist(
                        resultSet.getInt("id_artist"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getString("genderArtist"),
                        resultSet.getDate("birthday").toLocalDate(),
                        resultSet.getDate("deathDate").toLocalDate()
                );
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void update(Artist e) {
        String sql = "UPDATE Chanson SET name = ?, lastName = ?, genderArtist = ?, birthday = ?, deathdate = ? WHERE id_chanson = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,e.getName());
            statement.setString(2,e.getLastName());
            statement.setString(3,e.getGenderArtist());
            statement.setDate(4, Date.valueOf(e.getBirthday()));
            statement.setDate(5, Date.valueOf(e.getDeathDate()));

        } catch (SQLException ex) {
            throw new RuntimeException("Erreur lors de la mis à jour");
        }
    }

    @Override
    public Artist delete(int id) {
        Artist artistdel = this.findById(id);
        if(artistdel == null)
            return  null;
        String sql = "DELETE FROM artist WHERE id_artist = " + id;
        try{
            connection.prepareStatement(sql).executeUpdate();
            return artistdel;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
