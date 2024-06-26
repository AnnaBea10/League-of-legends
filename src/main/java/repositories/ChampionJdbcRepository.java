package repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import entities.Champion;

public class ChampionJdbcRepository implements ChampionRepository{

	private final JdbcTemplate jdbcTemplate;
	private final RowMapper<Champion> rowMapper;
	
	
	public ChampionJdbcRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.rowMapper = (rs, rowNum) -> new Champion (
				rs.getLong("id"),
				rs.getString("name"),
				rs.getString("role"),
				rs.getString("lore"),
				rs.getString("imageUrl")
				);
	}
	
	
	@Override
	public List<Champion> findAll() {
		return jdbcTemplate.query("SELECT * FROM CHAMPIONS", rowMapper);
	}
	
	@Override
	public Optional<Champion> findById(Long id) {
		String sql = "SELECT * FROM CHAMPIONS WHERE ID = ?";
		List<Champion> champions = jdbcTemplate.query(sql,rowMapper, id);
		return champions.stream().findFirst();
	}
}
