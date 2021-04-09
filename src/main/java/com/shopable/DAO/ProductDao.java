package com.shopable.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.shopable.model.ProductInformation;
import com.shopable.model.UserProduct;

@Component
public class ProductDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<ProductInformation> fetchall() {

		String sql = "select * from product_information order by product_id";
		return jdbcTemplate.query(sql, new MyRowMapper());
	}

	public List<UserProduct> getusercart(String name) {
		String sql = "SELECT count(*)\r\n" + "FROM information_schema.TABLES\r\n"
				+ "WHERE (TABLE_SCHEMA = 'shopable') AND (TABLE_NAME = " + "'" + name + "'" + ");";
		int nor = jdbcTemplate.queryForObject(sql, Integer.class);

		if (nor == 0) {
			String sql1 = "create table " + name
					+ "(product_id varchar(20),product_name varchar(50),quantity int,batchtotal int)";
			jdbcTemplate.update(sql1);
			return new ArrayList<UserProduct>();
		} else {
			String query = "select * from " + name;
			return jdbcTemplate.query(query, new MyRowMapper1());
		}

	}

	public int getstock(String id) {
		String sql2 = "select avilable_stock from product_information where product_id=" + id + ";";
		int stock = jdbcTemplate.queryForObject(sql2, Integer.class);
		return stock;
	}

	public void addtocart(String id, String uname, int quantity) {
		String sql = "select product_name from product_information where product_id=" + id;
		String pname = jdbcTemplate.queryForObject(sql, String.class);
		String sql1 = "select price from product_information where product_id=" + id;
		int cost = jdbcTemplate.queryForObject(sql1, Integer.class);
		int batchtotal = cost * quantity;
		String sql2 = "insert into " + uname + " values(?,?,?,?)";
		jdbcTemplate.update(sql2, id, pname, quantity, batchtotal);
		String sql3 = "select avilable_stock from product_information where Product_id =" + id;
		int availstock = jdbcTemplate.queryForObject(sql3, Integer.class);
		int diff = availstock - quantity;
		String sql4 = "update product_information set avilable_stock = " + diff + " where product_id=" + "'" + id + "'";
		jdbcTemplate.update(sql4);
		return;
	}

	public int total(String uname) {
		String sql = "select count(*) from " + uname + ";";
		int check = jdbcTemplate.queryForObject(sql, Integer.class);
		int total = 0;
		if (check > 0) {
			String sql1 = "select sum(batchtotal) from " + uname + "; ";
			total = jdbcTemplate.queryForObject(sql1, Integer.class);

		}

		return total;
	}

	public int walletmoney(String uname) {
		String sql = "select wallet_money from user_information where user_id = " + "'" + uname + "'";
		int w_money = jdbcTemplate.queryForObject(sql, Integer.class);
		return w_money;
	}

	public int moneycalc(String uname) {
		String sql3 = "select count(*) from " + uname + ";";
		int check = jdbcTemplate.queryForObject(sql3, Integer.class);

		if (check == 0) {
			return 2;
		}

		String sql = "select wallet_money from user_information where user_id = " + "'" + uname + "'";
		int w_money = jdbcTemplate.queryForObject(sql, Integer.class);
		String sql1 = "select sum(batchtotal) from " + uname + "; ";
		int total = jdbcTemplate.queryForObject(sql1, Integer.class);
		int diff = w_money - total;
		if (diff >= 0) {
			String sql2 = "update user_information set wallet_money = " + diff + " where user_id = " + "'" + uname
					+ "'";
			jdbcTemplate.update(sql2);
			return 1;
		} else {
			return 0;
		}

	}

	public void deletetable(String uname) {
		String sql = "SELECT count(*)\r\n" + "FROM information_schema.TABLES\r\n"
				+ "WHERE (TABLE_SCHEMA = 'shopable') AND (TABLE_NAME = " + "'" + uname + "'" + ");";
		int nor = jdbcTemplate.queryForObject(sql, Integer.class);
		if (nor > 0) {
			String sql1 = "drop table " + uname;
			jdbcTemplate.update(sql1);
		}
		return;
	}

	public void deletefromcart(String uname, String pid) {

		
		  
		String sql="select avilable_stock from product_information where Product_id ="+pid;
		  int availstock= jdbcTemplate.queryForObject(sql, Integer.class); 
		  
		  
		  String sql2="select quantity from "+uname+" where product_id="+pid; int
		  quant=jdbcTemplate.queryForObject(sql2, Integer.class); 
		  
		  int updatedstock=availstock+quant;
		  
		  
		  
		  String sql3="update product_information set avilable_stock = "+updatedstock+" where product_id="+pid;
		  jdbcTemplate.update(sql3); System.out.println(updatedstock);
		  
		  String sql1 = "delete from " + uname + " where product_id = " + pid;
		   jdbcTemplate.update(sql1);
		 

	}

	class MyRowMapper implements RowMapper<ProductInformation> {

		public ProductInformation mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			ProductInformation pi = new ProductInformation();
			pi.setProductid(rs.getString("product_id"));
			pi.setProductname(rs.getString("product_name"));
			pi.setPrice(rs.getInt("price"));
			pi.setAvailstock(rs.getInt("avilable_stock"));
			return pi;
		}
	}

	class MyRowMapper1 implements RowMapper<UserProduct> {

		//@Override
		public UserProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserProduct usp = new UserProduct();
			usp.setProductid(rs.getNString("product_id"));
			usp.setProductname(rs.getNString("product_name"));
			usp.setQuantity(rs.getInt("quantity"));
			usp.setBatchtotal(rs.getInt("batchtotal"));

			return usp;
		}

	}
}
