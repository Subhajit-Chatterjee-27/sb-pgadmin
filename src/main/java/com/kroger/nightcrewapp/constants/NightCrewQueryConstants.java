package com.kroger.nightcrewapp.constants;

public final class NightCrewQueryConstants {

	public static final String SQL_FIND_PERSON = "select * from person where id = ?";
	public static final String SQL_DELETE_PERSON = "delete from person where id = ?";
	public static final String SQL_UPDATE_PERSON = "update person set first_name = ?, last_name = ?, age  = ? where id = ?";
	public static final String SQL_GET_ALL = "select * from person";
	public static final String SQL_INSERT_PERSON = "insert into person(id, first_name, last_name, age) values(?,?,?,?)";
	public static final String SQL_INSERT_IMAGE = "insert into images_master(img_id, img_data, crtd_by, crtd_dte) values(?,?,?,?)";
	public static final String SQL_FIND_IMAGE = "select * from images_master where image_id = ?";
	public static final String SQL_STORE_IMAGE = "insert into store_images(image_id, image, created_by, created_date) values(?,?,?,?)";
	public static final String SQL_FETCH_STORED_IMAGE = "select * from store_images where image_id = ?";

}
