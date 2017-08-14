package com.evernote.edam;

/**
 * Object that is converted to / from thrift/protobufs
 *
 * This is converted to/from PBusiness
 *
 * @author patmoore
 *
 */
public class Business {

    /**
     * Not editable
     */
    public int id;

    /**
     * editable only by admin
     */
    public String name;

    /**
     * editable by all
     */
    public String description;

    public Business() {
    }

}
