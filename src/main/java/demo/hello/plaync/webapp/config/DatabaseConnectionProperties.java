package demo.hello.plaync.webapp.config;

import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "database")
public class DatabaseConnectionProperties {

	private Map<String, DataSourceProperties> connections;

	public Map<String, DataSourceProperties> getConnections() {
		return connections;
	}

	public void setConnections(Map<String, DataSourceProperties> connections) {
		this.connections = connections;
	}

	public static class DataSourceProperties {

		private String url;

		private String username;

		private String password;

		private int maxPoolSize;

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getMaxPoolSize() {
			return maxPoolSize;
		}

		public void setMaxPoolSize(int maxPoolSize) {
			this.maxPoolSize = maxPoolSize;
		}

	}

}