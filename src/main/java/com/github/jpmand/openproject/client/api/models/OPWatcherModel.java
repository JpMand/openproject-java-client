package com.github.jpmand.openproject.client.api.models;

/**
 * Represents a Watcher resource in OpenProject.
 * A watcher is a user who follows or watches a work package.
 * This class extends OPUserModel as watchers are essentially users in the context of watching.
 */
public class OPWatcherModel extends OPUserModel {

    /**
     * Default constructor.
     */
    public OPWatcherModel() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OPWatcherModel{");
        sb.append("id='").append(getId()).append('\'');
        sb.append(", name='").append(getName()).append('\'');
        sb.append(", email='").append(getEmail()).append('\'');
        sb.append(", login='").append(getLogin()).append('\'');
        sb.append(", type='").append(getType()).append('\'');
        sb.append(", links=").append(getLinks());
        sb.append('}');
        return sb.toString();
    }
}
