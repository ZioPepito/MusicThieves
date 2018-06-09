package musicthieves.wrapper;

import java.io.*;
import java.net.*;

import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.*;
import com.wrapper.spotify.enums.ModelObjectType;
import com.wrapper.spotify.exceptions.*;
import com.wrapper.spotify.model_objects.credentials.*;
import com.wrapper.spotify.model_objects.special.SearchResult;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.authorization.authorization_code.*;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.tracks.GetTrackRequest;

public class SpotifyWrapper {

	private static final String clientId = "ca280aac7ae6402b8a03fab1ec8bb0d9";
	private static final String clientSecret = "7ec17c5b96ec47c39b4e364535216e04";
	private static final URI redirectUri = SpotifyHttpManager.makeUri("http://musicthieves.com/Authcode");

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
	public static final URI uri = authorizationCodeUriRequest.execute();
	private static final GetTrackRequest getTrackRequest = spotifyApi.getTrack("0BAjUM6V9P9g8rK83hVUTJ")
	          .build();

	
	
	public void authorizationCode_Sync(String code) {
		try {
			AuthorizationCodeRequest authorizationCodeRequest = spotifyApi.authorizationCode(code)
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

	public void refreshAuth() {
		AuthorizationCodeRefreshRequest authorizationCodeRefreshRequest = spotifyApi.authorizationCodeRefresh()
				.build();
		try {
			final AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeRefreshRequest.execute();
			spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());
			spotifyApi.setRefreshToken(authorizationCodeCredentials.getRefreshToken());		  
		} catch (SpotifyWebApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//auth 2
	 private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
	          .build();

	  public static void clientCredentials_Sync() {
	    try {
	      final ClientCredentials clientCredentials = clientCredentialsRequest.execute();

	      // Set access token for further "spotifyApi" object usage
	      spotifyApi.setAccessToken(clientCredentials.getAccessToken());

	      System.out.println("Expires in: " + clientCredentials.getExpiresIn());
	    } catch (IOException | SpotifyWebApiException e) {
	      System.out.println("Error: " + e.getMessage());
	    }
	  }
	  
	  //end

	
	
	
	
	public void getTrack_Sync() {
	    try {
	      final Track track = getTrackRequest.execute();
	      System.out.println("Name: " + track.getName());
	    } catch (IOException | SpotifyWebApiException e) {
	      System.out.println("Error: " + e.getMessage());
	    }
	  }
	  
	  public String searchItem_Sync(String q, String type) {
		    try {
		      final SearchResult searchResult = spotifyApi.searchItem(q, type)
		              .market(CountryCode.IT)
		              .limit(10)
		              .offset(0)
		              .build()
		              .execute();

		      System.out.println(searchResult.getTracks().getNext());
		      return searchResult.getTracks().getNext();
		    } catch (IOException | SpotifyWebApiException e) {
		      System.out.println("Error: " + e.getMessage());
		    }
		    return null;
		  }

}