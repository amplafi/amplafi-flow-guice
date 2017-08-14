package com.evernote.persistant;

import com.evernote.edam.Business;

/**
 * persistent representation of {@link Business}
 * @author patmoore
 *
 */
public class PBusiness {
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
    public PBusiness() {
    }

}
