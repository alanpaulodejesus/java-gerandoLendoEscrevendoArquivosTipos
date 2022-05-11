package ArquivoJson;

import com.google.gson.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EscreverJson {


    public static void main(String[] args) throws IOException {

        Usuario user1 = new Usuario();
        user1.setCpf("4988484");
        user1.setLogin("user 1");
        user1.setSenha("senhaUser1");
        user1.setNome("user One");

        Usuario user2 = new Usuario();
        user2.setCpf("897878");
        user2.setLogin("User 2");
        user2.setSenha("senhaUser2");
        user2.setNome("user Two");

        List<Usuario> users = new ArrayList<Usuario>();
        users.add(user1);
        users.add(user2);

        Gson gson = new GsonBuilder().setPrettyPrinting().create(); //Organiza os dados no json

        String jsonUser = gson.toJson(users);

        System.out.println(jsonUser);

        FileWriter fileWriter = new FileWriter("src/main/java/ArquivoJson/arquivo.json");

        fileWriter.write(jsonUser);
        fileWriter.flush();
        fileWriter.close();

        //-------------\lendo json/--------------//

        FileReader fileReader = new FileReader("src/main/java/ArquivoJson/arquivo.json");
        JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);

        List<Usuario> listaUser = new ArrayList<Usuario>();

        for (JsonElement jsonElement:jsonArray   ) {

            Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
            listaUser.add(usuario);
        }

        System.out.println("Leitura arquivo json: "+listaUser);
    }
}
