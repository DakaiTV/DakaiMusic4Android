package org.abrantes.filex;

import java.io.File;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.GradientDrawable;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;


public class PlaylistCursorAdapter extends SimpleCursorAdapter{
//	String						FILEX_FILENAME_EXTENSION = "";
//    String						FILEX_ALBUM_ART_PATH = "/sdcard/albumthumbs/RockOn/";
//    String						FILEX_SMALL_ALBUM_ART_PATH = "/sdcard/albumthumbs/RockOn/small/";
//    String						FILEX_CONCERT_PATH = "/sdcard/RockOn/concert/";
//    double 						CURRENT_PLAY_SCREEN_FRACTION = 0.66;
//    double 						CURRENT_PLAY_SCREEN_FRACTION_LANDSCAPE = 0.75;
//    double 						NAVIGATOR_SCREEN_FRACTION = 1 - CURRENT_PLAY_SCREEN_FRACTION;
//    double		 				NAVIGATOR_SCREEN_FRACTION_LANDSCAPE = 1 - CURRENT_PLAY_SCREEN_FRACTION_LANDSCAPE;
    
//    private final int 			NO_COVER_SAMPLING_INTERVAL = 3;
    public Cursor 				cursor;
    public Context	 			context;
//    public int					viewWidth;
//    private LayoutParams 		params = null;
//    private GradientDrawable	overlayGradient = null;
//    public Bitmap				albumCoverBitmap;
//    public BitmapFactory		bitmapDecoder = new BitmapFactory();
//    public ImageView 			albumImage = null;
//    public ImageView 			albumImageOverlay = null;
//    public TextView				albumNameTextView = null;
//    public TextView				albumArtistTextView = null;
//	public String 				albumCoverPath = null;    
//	public String 				artistName = null;
//	public String 				albumName = null;
//	public String 				path = null;
//	public File 				albumCoverFilePath = null;
//	public Options 				opts = null;
//	public Bitmap[] 			albumImages;
//	public Bitmap				albumUndefinedCoverBitmap;
//	private	boolean				PRELOAD = false;
//	private int					AVOID_PRELOAD_THRESHOLD = 500;

    public PlaylistCursorAdapter(Context context, 
    							int layout, 
    							Cursor c,
    							String[] from,
    							int[] to){
        super(context, layout, c, from, to);
        this.cursor = c;
        this.context = context;
//        
//        /*
//         * Read the width of the Navigator
//         */
////    	if(((Filex) context).display.getOrientation() == 0)
////	        viewWidth = (int) Math.floor(
////	        				((Filex) context).display.getWidth() * 
////	        				((Filex) context).NAVIGATOR_SCREEN_FRACTION
////	        				);
////    	else    
////    		viewWidth = (int) Math.floor(
////    				((Filex) context).display.getWidth() * 
////    				((Filex) context).NAVIGATOR_SCREEN_FRACTION_LANDSCAPE
////    				);
//        
//        WindowManager windowManager 		= (WindowManager) 
//												context.getSystemService(Context.WINDOW_SERVICE);
//    	Display display						= windowManager.getDefaultDisplay();
//        
//    	if(display.getOrientation() == 0)
//	        viewWidth = (int) Math.floor(
//	        				display.getWidth() * 
//	        				NAVIGATOR_SCREEN_FRACTION
//	        				);
//    	else    
//    		viewWidth = (int) Math.floor(
//    				display.getWidth() * 
//    				NAVIGATOR_SCREEN_FRACTION_LANDSCAPE
//    				);
//    	params = new LayoutParams(viewWidth, viewWidth);
//    	//params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 1);
//        
//        /*
//         * Create the Overlay Gradient
//         */
////        overlayGradient = new GradientDrawable(GradientDrawable.Orientation.TL_BR,
////                								new int[] { 0x00000000, 
////        													0x22FFFFFF,
////        													0x00000000 });
////        overlayGradient.setGradientCenter((float) Math.floor(viewWidth * 0.75),
////        									(float) Math.floor(viewWidth * 0.75));
////        //overlayGradient.setGradientRadius((float) (viewWidth*0.75));
////        //overlayGradient.setGradientType(GradientDrawable.RECTANGLE);
////        overlayGradient.setShape(GradientDrawable.RECTANGLE);
//        
//        /*
//         * Preload album Images into memory to avoid dynamic loading
//         */
//        if(c.getCount() < AVOID_PRELOAD_THRESHOLD){
//        	albumImages = new Bitmap[c.getCount()];
//        	preloadAlbumImages(albumImages);
//        	PRELOAD = true;
//        }
//        
//        /*
//         * Preload the undefined album image
//         */
//		// TODO:
//		// adjust sample size dynamically
//		opts = new Options();
//		opts.inSampleSize = NO_COVER_SAMPLING_INTERVAL;
//		//Bitmap albumCoverBitmap = BitmapFactory.decodeFile(albumCoverPath, opts);
//		albumUndefinedCoverBitmap = bitmapDecoder.decodeResource(this.context.getResources(),
//														R.drawable.albumart_mp_unknown, opts);
    }

    
    /* (non-Javadoc)
     * This is where you actually create the item view of the list
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    	try{
    		/*
    		 * Put the playlist name on the screen
    		 */
    		TextView playlistName = (TextView) view.findViewById(R.id.playlist_name);
    		playlistName.setText(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Playlists.NAME)));
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
//    	try{
//	    	/*
//	    	 * Get the item list image component set its height right
//	    	 */
//	    	albumImage = 			(ImageView)
//	    									view.findViewById(R.id.navigator_albumart_image);
//	    	albumImage.setLayoutParams(params);
//	    	
//	    	albumImageOverlay = 	(ImageView)
//	    									view.findViewById(R.id.navigator_albumart_overlay);
//	    	//albumImageOverlay.setImageDrawable(overlayGradient);
//	    	albumImageOverlay.setLayoutParams(params);
//	    	
//	    	// TODO: needs a if(albums in full screen)
//	    	albumNameTextView = (TextView)
//	    									view.findViewById(R.id.navigator_albumname);
//	    	albumArtistTextView = (TextView)
//	    									view.findViewById(R.id.navigator_albumartist);
//	    	albumNameTextView.setText(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM)));
//	    	albumArtistTextView.setText(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums.ARTIST)));
//	    	
//	    	/*
//	    	 * if preload is in use, get the preloaded bitmap, otherwise go get it
//	    	 */
//	    	if(PRELOAD){
//	    		if(albumImage != null && cursor != null){
//	    			if(albumImages[cursor.getPosition()] != null)
//	    				albumImage.setImageBitmap(albumImages[cursor.getPosition()]);
//	    			else
//	    				albumImage.setImageBitmap(albumUndefinedCoverBitmap);
//	    		}
//	    		return;
//	    	}
//    	} catch(Exception e) {
//    		//albumImage.setImageBitmap(albumUndefinedCoverBitmap);
//    		e.printStackTrace();
//    		return;
//    	}
//    	
//    	/*
//    	 * Get Album Art pointer
//    	 */
//    	albumCoverPath = null;
////    	String albumCoverPath = cursor.getString(
////    								cursor.getColumnIndex(
////    									MediaStore.Audio.Albums.ALBUM_ART));
////    	// if it does not exist in database look for our dir
////    	if(albumCoverPath == null){
//    		artistName = cursor.getString(
//									cursor.getColumnIndex(
//											MediaStore.Audio.Albums.ARTIST));
//    		albumName = cursor.getString(
//									cursor.getColumnIndex(
//											MediaStore.Audio.Albums.ALBUM));
//    		path = FILEX_SMALL_ALBUM_ART_PATH+
//    						validateFileName(artistName)+
//							" - "+
//							validateFileName(albumName)+
//							FILEX_FILENAME_EXTENSION;
//    		Log.i("LOAD_ART", path);
//    		albumCoverFilePath = new File(path);
//			if(albumCoverFilePath.exists() && albumCoverFilePath.length() > 0){
//				albumCoverPath = path;
//			}
////    	}
//    	
//    	/*
//		 * If the album art exists put it in the listView, otherwise
//		 * just use the default image
//		 */
//		if(albumCoverPath != null){
//			/*
//			 * First check the albumThumbsize and then get the album art just
//			 * with the resolution that is strictly required
//			 */
////			Options opts = new Options();
////			opts.inJustDecodeBounds = true;
////			Bitmap albumCoverBitmap = BitmapFactory.decodeFile(albumCoverPath, opts);
////
////			opts.inJustDecodeBounds = false;
////			opts.inSampleSize = (int) Math.max(1, 
////												Math.floor(opts.outWidth/viewWidth)
////												);
////			Log.i("ALBUMADAPTER", ""+opts.inSampleSize);
//			//Optimization time
//			//opts.inSampleSize = 3;
////			albumCoverBitmap = BitmapFactory.decodeFile(albumCoverPath, opts);
//			albumCoverBitmap = bitmapDecoder.decodeFile(albumCoverPath);
//			
//			//albumCoverBitmap = Bitmap.createScaledBitmap(albumCoverBitmap,
//			//												30,
//			//												30,
//			//												false);
//			
//			if(albumCoverBitmap != null)
//				albumImage.setImageBitmap(albumCoverBitmap);
//		} else {
//			// TODO:
//			// adjust sample size dynamically
//			opts = new Options();
//			opts.inSampleSize = NO_COVER_SAMPLING_INTERVAL;
//			//Bitmap albumCoverBitmap = BitmapFactory.decodeFile(albumCoverPath, opts);
//			albumCoverBitmap = bitmapDecoder.decodeResource(this.context.getResources(),
//															R.drawable.albumart_mp_unknown, opts);
//			if(albumCoverBitmap != null)
//				albumImage.setImageBitmap(albumCoverBitmap);
//		}
    }
}