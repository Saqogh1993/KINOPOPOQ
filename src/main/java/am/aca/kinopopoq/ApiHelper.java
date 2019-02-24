package am.aca.kinopopoq;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

public class ApiHelper {
    private OkHttpClient client = new OkHttpClient();

    public String getTrailerId(String movieId) throws IOException {

        Response response = null;
        Request request = new Request.Builder()
                .url("http://api.themoviedb.org/3/movie/tt" + movieId + "/videos?api_key=c5f06ba74ed664a787ef5e00fbed6539")
                .get()
                .build();
        {
            try {
                response = client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String jsonString = Objects.requireNonNull(Objects.requireNonNull(response).body()).string();
        JSONObject obj = new JSONObject(jsonString);
        JSONArray arr = obj.getJSONArray("results");
        String youtubeLink = arr.getJSONObject(0).getString("key");
        return "https://www.youtube.com/embed/" + youtubeLink;

    }

}

