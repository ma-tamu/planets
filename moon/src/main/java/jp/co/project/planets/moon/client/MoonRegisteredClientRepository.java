package jp.co.project.planets.moon.client;

import jp.co.project.planets.pleiades.db.dao.OAuthClientDao;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Component;

@Component
public class MoonRegisteredClientRepository implements RegisteredClientRepository {

    private final OAuthClientDao oauthClientDao;

    public MoonRegisteredClientRepository(final OAuthClientDao oauthClientDao) {
        this.oauthClientDao = oauthClientDao;
    }

    @Override
    public void save(RegisteredClient registeredClient) {

    }

    @Override
    public RegisteredClient findById(String id) {
        return null;
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        return null;
    }
}
