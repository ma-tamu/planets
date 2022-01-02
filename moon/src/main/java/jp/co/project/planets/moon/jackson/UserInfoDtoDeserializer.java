package jp.co.project.planets.moon.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jp.co.project.planets.moon.model.dto.UserInfoDto;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Optional;

/**
 * user info dto deserializer
 */
public class UserInfoDtoDeserializer extends JsonDeserializer<UserInfoDto> {
    @Override
    public UserInfoDto deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
        final var mapper = (ObjectMapper) parser.getCodec();
        final var root = (JsonNode) mapper.readTree(parser);
        final var id = findJsonValue(root, "id");
        final var loginId = findJsonValue(root, "id");
        final var password = findJsonValue(root, "id");
        final var name = findJsonValue(root, "id");
        return new UserInfoDto(id, loginId, password, name, false, false);
    }

    private String findJsonValue(JsonNode jsonNode, String fieldName) {
        return Optional.ofNullable(jsonNode.findValue(fieldName)).map(JsonNode::asText).orElse(StringUtils.EMPTY);
    }
}
