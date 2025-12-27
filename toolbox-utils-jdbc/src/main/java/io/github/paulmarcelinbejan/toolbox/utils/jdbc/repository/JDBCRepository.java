package io.github.paulmarcelinbejan.toolbox.utils.jdbc.repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

/**
 * JDBCRepository contains common operations that can be executed on database by passing a sql query
 */
@Slf4j
@Repository
public class JDBCRepository {

	/**
	 * Constructor.
	 *
	 * @param jdbcTemplate the JdbcTemplate.
	 * @param namedParameterJdbcTemplate the NamedParameterJdbcTemplate.
	 */
	protected JDBCRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	protected final JdbcTemplate jdbcTemplate;

    protected final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
    //
    // SELECT
    //
    
    @Transactional
    public Long selectNextSequenceValue(String sql, String sequenceName) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("sequenceName", sequenceName);

//        log.debug("SQL query: {}", sql);
//        log.trace("SQL query params: {}", params);
        
        try {
            return namedParameterJdbcTemplate.queryForObject(sql, params, Long.class);
        } catch (@SuppressWarnings( "unused" ) EmptyResultDataAccessException e) {
            throw new RuntimeException(e);
        }
    }
	
    /**
     * Executes a query and returns a single result as an Optional.
     *
     * @param sql the SQL query to execute.
     * @param resultClass the class of the entity.
     *
     * @return an Optional containing the result, or an empty Optional if no result is found.
     */
    @Transactional( readOnly = true )
    public <T> Optional<T> selectOne(String sql, Class<T> resultClass) {
        try {
            T result = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(resultClass));
            return Optional.ofNullable(result);
        } catch (@SuppressWarnings( "unused" ) EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    /**
     * Executes a query with named parameters and returns a single result as an Optional.
     *
     * @param sql         the SQL query to execute.
     * @param paramSource a pojo containing the parameters for the query.
     * @param resultClass the class of the entity.
     *
     * @return an Optional containing the result, or an empty Optional if no result is found.
     */
    @Transactional( readOnly = true )
    public <T> Optional<T> selectOne(String sql, Object paramSource, Class<T> resultClass) {
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(paramSource);
        try {
            T result = namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, new BeanPropertyRowMapper<>(resultClass));
            return Optional.ofNullable(result);
        } catch (@SuppressWarnings( "unused" ) EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
    
    /**
     * Executes a query with named parameters and returns a single result as an Optional.
     *
     * @param sql         the SQL query to execute.
     * @param paramSource the Map of source containing the parameters for SQL statement.
     * @param resultClass the class of the entity.
     *
     * @return an Optional containing the result, or an empty Optional if no result is found.
     */
    @Transactional( readOnly = true )
    public <T> Optional<T> selectOne(String sql, Map<String, ?> paramSource, Class<T> resultClass) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(paramSource);
        try {
            T result = namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, new BeanPropertyRowMapper<>(resultClass));
            return Optional.ofNullable(result);
        } catch (@SuppressWarnings( "unused" ) EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    /**
     * Executes a query and returns a list of results.
     *
     * @param sql the SQL query to execute.
     * @param resultClass the class of the entity.
     *
     * @return a list of results.
     */
    @Transactional( readOnly = true )
    public <T> List<T> select(String sql, Class<T> resultClass) {
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(resultClass));
    }

    /**
     * Executes a query with named parameters and returns a list of results.
     *
     * @param sql         the SQL query to execute.
     * @param paramSource the source containing the parameters for SQL statement.
     * @param resultClass the class of the entity.
     *
     * @return a list of results.
     */
    @Transactional( readOnly = true )
    public <T> List<T> select(String sql, Object paramSource, Class<T> resultClass) {
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(paramSource);
        return namedParameterJdbcTemplate.query(sql, sqlParameterSource, new BeanPropertyRowMapper<>(resultClass));
    }
    
    /**
     * Executes a query with named parameters and returns a list of results.
     *
     * @param sql         the SQL query to execute.
     * @param paramSource the Map of source containing the parameters for SQL statement.
     * @param resultClass the class of the entity.
     *
     * @return a list of results.
     */
    @Transactional( readOnly = true )
    public <T> List<T> select(String sql, Map<String, ?> paramSource, Class<T> resultClass) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(paramSource);
        return namedParameterJdbcTemplate.query(sql, sqlParameterSource, new BeanPropertyRowMapper<>(resultClass));
    }
    
    /**
     * Executes a query and returns a list of results.
     *
     * @param sql the SQL query to execute.
     * @param resultClass the class of the entity.
     *
     * @return a set of results.
     */
    @Transactional( readOnly = true )
    public <T> Set<T> selectDistinct(String sql, Class<T> resultClass) {
        return new HashSet<>(jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(resultClass)));
    }

    /**
     * Executes a query with named parameters and returns a list of results.
     *
     * @param sql         the SQL query to execute.
     * @param paramSource the source containing the parameters for SQL statement.
     * @param resultClass the class of the entity.
     *
     * @return a set of results.
     */
    @Transactional( readOnly = true )
    public <T> Set<T> selectDistinct(String sql, Object paramSource, Class<T> resultClass) {
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(paramSource);
        return new HashSet<>(namedParameterJdbcTemplate.query(sql, sqlParameterSource, new BeanPropertyRowMapper<>(resultClass)));
    }
    
    /**
     * Executes a query with named parameters and returns a list of results.
     *
     * @param sql         the SQL query to execute.
     * @param paramSource the Map of source containing the parameters for SQL statement.
     * @param resultClass the class of the entity.
     *
     * @return a set of results.
     */
    @Transactional( readOnly = true )
    public <T> Set<T> selectDistinct(String sql, Map<String, ?> paramSource, Class<T> resultClass) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(paramSource);
        return new HashSet<>(namedParameterJdbcTemplate.query(sql, sqlParameterSource, new BeanPropertyRowMapper<>(resultClass)));
    }
    
    //
    // INSERT
    //
    
	/**
	 * Executes sql query with paramSource containing the parameters for SQL statement
	 *
	 * @param sql         the SQL INSERT statement.
	 * @param paramSource the source containing the parameters for SQL statement.
	 */
	@Transactional
	public <T> void insert(String sql, T paramSource) {
		executeQuery(sql, paramSource);
	}
	
	/**
	 * Executes sql query with paramSource containing the parameters for SQL statement
	 *
	 * @param sql         the SQL INSERT statement.
	 * @param paramSource the Map of source containing the parameters for SQL statement.
	 */
	@Transactional
	public void insert(String sql, Map<String, ?> paramSource) {
		executeQuery(sql, paramSource);
	}

	/**
	 * Executes sql query for each element of paramSources (containing the parameters for SQL statement)
	 *
	 * @param sql          the SQL INSERT statement.
	 * @param paramSources the list of source containing the parameters for SQL statement.
	 */
	@Transactional
	public <T> void insert(String sql, Collection<T> paramSources) {
		executeQuery(sql, paramSources);
	}
	
	/**
	 * Executes sql query for each element of paramSources (containing the parameters for SQL statement)
	 *
	 * @param sql          the SQL INSERT statement.
	 * @param paramSources the array of Map of source containing the parameters for SQL statement.
	 */
	@Transactional
	public <T> void insert(String sql, Map<String, ?>[] paramSources) {
		executeQuery(sql, paramSources);
	}
	
    //
    // UPDATE
    //
	
	/**
	 * Executes sql query with paramSource containing the parameters for SQL statement
	 *
	 * @param sql         the SQL UPDATE statement.
	 * @param paramSource the source containing the parameters for SQL statement.
	 */
	@Transactional
	public <T> void update(String sql, T paramSource) {
		executeQuery(sql, paramSource);
	}
	
	/**
	 * Executes sql query with paramSource containing the parameters for SQL statement
	 *
	 * @param sql         the SQL UPDATE statement.
	 * @param paramSource the Map of source containing the parameters for SQL statement.
	 */
	@Transactional
	public void update(String sql, Map<String, ?> paramSource) {
		executeQuery(sql, paramSource);
	}

	/**
	 * Executes sql query for each element of paramSources (containing the parameters for SQL statement)
	 *
	 * @param sql          the SQL UPDATE statement.
	 * @param paramSources the list of source containing the parameters for SQL statement.
	 */
	@Transactional
	public <T> void update(String sql, Collection<T> paramSources) {
		executeQuery(sql, paramSources);
	}
	
	/**
	 * Executes sql query for each element of paramSources (containing the parameters for SQL statement)
	 *
	 * @param sql          the SQL UPDATE statement.
	 * @param paramSources the array of Map of source containing the parameters for SQL statement.
	 */
	@Transactional
	public <T> void update(String sql, Map<String, ?>[] paramSources) {
		executeQuery(sql, paramSources);
	}
	
    //
    // DELETE
    //
	
	/**
	 * Executes sql query with paramSource containing the parameters for SQL statement
	 *
	 * @param sql         the SQL DELETE statement.
	 * @param paramSource the source containing the parameters for SQL statement.
	 */
	@Transactional
	public <T> void delete(String sql, T paramSource) {
		executeQuery(sql, paramSource);
	}
	
	/**
	 * Executes sql query with paramSource containing the parameters for SQL statement
	 *
	 * @param sql         the SQL DELETE statement.
	 * @param paramSource the Map of source containing the parameters for SQL statement.
	 */
	@Transactional
	public void delete(String sql, Map<String, ?> paramSource) {
		executeQuery(sql, paramSource);
	}

	/**
	 * Executes sql query for each element of paramSources (containing the parameters for SQL statement)
	 *
	 * @param sql          the SQL DELETE statement.
	 * @param paramSources the list of source containing the parameters for SQL statement.
	 */
	@Transactional
	public <T> void delete(String sql, Collection<T> paramSources) {
		executeQuery(sql, paramSources);
	}
	
	/**
	 * Executes sql query for each element of paramSources (containing the parameters for SQL statement)
	 *
	 * @param sql          the SQL DELETE statement.
	 * @param paramSources the array of Map of source containing the parameters for SQL statement.
	 */
	@Transactional
	public void delete(String sql, Map<String, ?>[] paramSources) {
		executeQuery(sql, paramSources);
	}
	
    //
    // EXECUTE QUERY
    //
	
	/**
	 * Executes sql query with paramSource containing the parameters for SQL statement
	 *
	 * @param sql         the SQL statement.
	 * @param paramSource the source containing the parameters for SQL statement.
	 * @return the number of rows affected.
	 */
	private <T> int executeQuery(String sql, T paramSource) {
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(paramSource);
		return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
	}
	
	/**
	 * Executes sql query with paramSource containing the parameters for SQL statement
	 *
	 * @param sql         the SQL statement.
	 * @param paramSource the Map of source containing the parameters for SQL statement.
	 * @return the number of rows affected.
	 */
	private int executeQuery(String sql, Map<String, ?> paramSource) {
		final SqlParameterSource sqlParameterSource = new MapSqlParameterSource(paramSource);
		return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
	}
	
	/**
	 * Executes sql query for each element of paramSources (containing the parameters for SQL statement)
	 *
	 * @param sql          the SQL statement.
	 * @param paramSources the list of source containing the parameters for SQL statement.
	 * @return the number of rows affected.
	 */
	private <T> int[] executeQuery(String sql, Collection<T> paramSources) {
		SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(paramSources);
		return namedParameterJdbcTemplate.batchUpdate(sql, batchArgs);
	}
	
	/**
	 * Executes sql query for each element of paramSources (containing the parameters for SQL statement)
	 *
	 * @param sql          the SQL statement.
	 * @param paramSources the array of Map of source containing the parameters for SQL statement.
	 * @return the number of rows affected.
	 */
	private int[] executeQuery(String sql, Map<String, ?>[] paramSources) {
		SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(paramSources);
		return namedParameterJdbcTemplate.batchUpdate(sql, batchArgs);
	}

}
