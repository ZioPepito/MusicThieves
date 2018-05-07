package musicthieves.wrapper;

import java.io.*;
import java.net.*;
import com.wrapper.spotify.*;
import com.wrapper.spotify.exceptions.*;
import com.wrapper.spotify.model_objects.credentials.*;
import com.wrapper.spotify.requests.authorization.authorization_code.*;

public class SpotifyWrapper {
	
	public static void main(String[] args) {
		authorizationCode_Sync();
		/*SpotifyApi spotifyApi = new SpotifyApi.Builder().setAccessToken("BQBCvZfobradHrNf22pw7-QLQIqTnCUUKjvgITyst38svcsZUgd6vETFK22nCohG7aOCrwm0QteMNJYQINbiR9iYDGjCIv2dtXrdE9Qfj8CCfX7nblXKSojmlPHNqf6KO-n2YWLf8fUMqgszwQnwasLze5rhB2KUW__fJvB4qZcMoGJ9PJUKqw")
				  .build();*/
		try {
			System.out.println(spotifyApi.getArtist("2ye2Wgw4gimLv2eAKyk1NB").build().execute().getName());
		} catch (SpotifyWebApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static final String clientId = "ca280aac7ae6402b8a03fab1ec8bb0d9";
	  private static final String clientSecret = "7ec17c5b96ec47c39b4e364535216e04";
	  private static final URI redirectUri = SpotifyHttpManager.makeUri("localhost:8080/MusicThieves/test");

	  private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
	          .setClientId(clientId)
	          .setClientSecret(clientSecret)
	          .setRedirectUri(redirectUri)
	          .build();
	  private static final AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
	          .state("x4xkmn9pu3j6ukrs8n")
	          .scope("user-read-birthdate,user-read-email")
	          .show_dialog(true)
	          .build();
	  private static final URI uri = authorizationCodeUriRequest.execute();
	  /*private static final AuthorizationCodeRequest authorizationCodeRequest = spotifyApi.authorizationCode(uri.toString())
	          .build();*/

	  public static void authorizationCode_Sync() {
	    try {
	    	System.out.println(uri);
	    	AuthorizationCodeRequest authorizationCodeRequest = spotifyApi.authorizationCode(uri.toString())
	  	          .build();
	      final AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeRequest.execute();

	      // Set access and refresh token for further "spotifyApi" object usage
	      spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());
	      spotifyApi.setRefreshToken(authorizationCodeCredentials.getRefreshToken());

	      System.out.println("Expires in: " + authorizationCodeCredentials.getExpiresIn());
	    } catch (IOException | SpotifyWebApiException e) {
	      System.out.println("Error: " + e.getMessage());
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	
}