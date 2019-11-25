package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import part.PartType;
import part.dto.Part;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

import java.util.List;

public class Converter {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static JsonNode rootNode;

    public static void setRootNodeFromHttpRequest(HttpServletRequest req) throws IOException {
        rootNode = MAPPER.readTree(req.getReader());
    }

    public static PartType getPartTypeFromJson() {
        JsonNode typeNode = rootNode.path("type");

        return PartType.getType(typeNode.asText());
    }

    public static List < Part > getPartsListFromJson() throws IOException {
        JsonNode partsNode = rootNode.path("parts");

        return MAPPER.readValue(partsNode.toString(), new TypeReference < List < Part > >() {
        });
    }

    public static String getPartsJsonFromObject(List<Part> parts) throws JsonProcessingException {
        return MAPPER.writeValueAsString(parts);
    }
}
