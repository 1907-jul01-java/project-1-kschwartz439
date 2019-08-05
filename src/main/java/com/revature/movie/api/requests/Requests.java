package com.revature.movie.api.requests;

import javax.xml.bind.annotation.XmlRootElement;

import com.revature.movie.api.users.User;

@XmlRootElement
public class Requests {
    User user = new User();
    private String requestName;
    private String requestType;
    private double cost;
    private String requestDescription;
    private String username = user.getUsername();
    private String approved;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public void setRequestDescription(String requestDescription) {
        this.requestDescription = requestDescription;
    }

    public Requests() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        user = this.getUser();
        user.setUsername(username);
        this.username = username;
    }

    @Override
    public String toString() {
        return "Requests [cost=" + cost + ", requestDescription=" + requestDescription + ", requestName=" + requestName
                + ", requestType=" + requestType + ", user=" + user + ", username=" + username + "]";
    }

    public Requests(String requestName, String requestType, double cost, String requestDescription, String username,
            String approved) {
        this.requestName = requestName;
        this.requestType = requestType;
        this.cost = cost;
        this.requestDescription = requestDescription;
        this.username = username;
        this.approved = approved;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((approved == null) ? 0 : approved.hashCode());
        long temp;
        temp = Double.doubleToLongBits(cost);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((requestDescription == null) ? 0 : requestDescription.hashCode());
        result = prime * result + ((requestName == null) ? 0 : requestName.hashCode());
        result = prime * result + ((requestType == null) ? 0 : requestType.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Requests other = (Requests) obj;
        if (approved == null) {
            if (other.approved != null)
                return false;
        } else if (!approved.equals(other.approved))
            return false;
        if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
            return false;
        if (requestDescription == null) {
            if (other.requestDescription != null)
                return false;
        } else if (!requestDescription.equals(other.requestDescription))
            return false;
        if (requestName == null) {
            if (other.requestName != null)
                return false;
        } else if (!requestName.equals(other.requestName))
            return false;
        if (requestType == null) {
            if (other.requestType != null)
                return false;
        } else if (!requestType.equals(other.requestType))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }

    public Requests(String requestName, String requestType, double cost, String requestDescription, String username) {
        this.requestName = requestName;
        this.requestType = requestType;
        this.cost = cost;
        this.requestDescription = requestDescription;
        this.username = username;
    }

}