package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import model.Enseignant;
import model.FicheDeVoeux;
import model.Sujet;

public class FicheDeVoeuxDaoImpl implements FicheDeVoeuxDao {
	
	
	public boolean create(FicheDeVoeux fiche) {
		Connection conn=DbConnect.connect();

		String sql = "INSERT INTO fichedevoeux (id, id_Sujet,ordre) "
				+ "VALUES (?, ?, ?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, fiche.getId());
			ps.setInt(2, fiche.getIdSujet());
			ps.setInt(3, fiche.getOrdre());

			ps.execute();
			conn.close();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			
			return false;
		}
	}

	public boolean delete(FicheDeVoeux e) {
		Connection conn=DbConnect.connect();
		boolean verif = false ;
		
		String sql = "DELETE FROM fichedevoeux WHERE id=?";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, e.getId());
			
			verif=ps.execute();
			conn.close();
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();	
		}
		
		return verif ;
	}

	public boolean update(FicheDeVoeux fiche , int idSujetAncien) {
		Connection conn=DbConnect.connect();
		String sql = "UPDATE fichedevoeux SET id_Sujet=? WHERE id=? AND id_Sujet=? AND ordre = ? ";
				
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, fiche.getIdSujet());
			ps.setInt(2, fiche.getId());
			ps.setInt(3, idSujetAncien);
			ps.setInt(4, fiche.getOrdre());

			ps.execute();
			conn.close();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			
			return false;
		}
	}

	public FicheDeVoeux findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<FicheDeVoeux> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int nbrSujeuts(int id) {
		Connection conn=DbConnect.connect();
		String sql = "SELECT COUNT(id) FROM fichedevoeux WHERE id=?";
		int result =0 ;
		PreparedStatement ps;
		ResultSet rs =null ;
		
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1 , id);
			rs=ps.executeQuery();
			if (rs.next()){
				
					result = rs.getInt(1);
				
			}
			conn.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		
		return result;
	}

	public List<Sujet> listSujets(int idficheDevoeux) {
		Connection conn=DbConnect.connect();
		
		String sql = "Select * FROM fichedevoeux,sujet WHERE fichedevoeux.id=? and fichedevoeux.id_Sujet=sujet.id order by ordre asc ";
		PreparedStatement ps;
		ResultSet rs = null ;
		List<Sujet> sujets= new ArrayList<Sujet>();
		Sujet sujet = null ;
		
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, idficheDevoeux);
			rs=ps.executeQuery();
			
			while (rs.next()){
				sujet = new Sujet(
						rs.getInt("id_Sujet"),
						rs.getString("titre"), 
						rs.getString("contenu"), 
						rs.getString("specialite"), 
						rs.getDate("date_creation"),
						rs.getInt("id_Enseignant")
						);
				
				sujets.add(sujet);
			}	
			conn.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return sujets;
	}

	public FicheDeVoeux findByIdAndOrdre(int id, int ordre) {
		Connection conn=DbConnect.connect();
		
		String sql = "Select * FROM fichedevoeux WHERE id=? and ordre=?";
		PreparedStatement ps;
		ResultSet rs =null ;
		FicheDeVoeux fiche_de_voeux=null ;
		
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, ordre);
			rs=ps.executeQuery();
			if (rs.next()){
				fiche_de_voeux = new FicheDeVoeux(
						rs.getInt("id"),
						rs.getInt("id_Sujet"),
						rs.getInt("ordre")
						);
			}	
			conn.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return fiche_de_voeux;
		
	}

	public boolean deleteAll() {

		Connection conn=DbConnect.connect();
		boolean verif = false ;
		
		String sql = "DELETE FROM fichedevoeux WHERE 1";
		String sql2= "UPDATE etudiant set taux = 0 WHERE 1 "; 
		PreparedStatement ps;
		try {
			
			ps = (PreparedStatement) conn.prepareStatement(sql);
			verif=ps.execute();
			ps = (PreparedStatement) conn.prepareStatement(sql2);
			ps.execute() ;
			conn.close();
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();	
		}
		
		return verif ;
	}

		
		
	
	

}
