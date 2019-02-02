package org.qjson.junit.md;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

interface LoadTestData {

    static Node $(Class clazz) {
        try {
            String path = "/" + clazz.getCanonicalName().replace(".", "/") + ".md";
            List<Extension> extensions = Arrays.asList(TablesExtension.create());
            Parser parser = Parser.builder()
                    .extensions(extensions)
                    .build();
            try (InputStream inputStream = clazz.getResourceAsStream(path)) {
                if (inputStream == null) {
                    throw new RuntimeException("test resource not found: " + path);
                }
                try (InputStreamReader reader = new InputStreamReader(inputStream)) {
                    return parser.parseReader(reader);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
