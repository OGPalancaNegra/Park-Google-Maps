package com.example.nottinghamrestaurants.model;


import java.util.HashMap;
import java.util.Map;


public class NottinghamRestaurants {

    private String id;
    private Integer fhrsid;
    private String businessName;
    private String businessType;
    private Integer businessTypeID;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String postCode;
    private Integer ratingValue;
    private String ratingKey;
    private String ratingDate;
    private Integer localAuthorityCode;
    private String localAuthorityName;
    private String localAuthorityWebSite;
    private String localAuthorityEmailAddress;
    private String schemeType;
    private Boolean newRatingPending;
    private Double geocodeLongitude;
    private Double geocodeLatitude;
    private Integer scoresHygiene;
    private Integer scoresStructural;
    private Integer scoresConfidenceInManagement;
    private String addressLine4;
    private Integer localAuthorityBusinessID;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getFhrsid() {
        return fhrsid;
    }

    public void setFhrsid(Integer fhrsid) {
        this.fhrsid = fhrsid;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Integer getBusinessTypeID() {
        return businessTypeID;
    }

    public void setBusinessTypeID(Integer businessTypeID) {
        this.businessTypeID = businessTypeID;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Integer getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(Integer ratingValue) {
        this.ratingValue = ratingValue;
    }

    public String getRatingKey() {
        return ratingKey;
    }

    public void setRatingKey(String ratingKey) {
        this.ratingKey = ratingKey;
    }

    public String getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(String ratingDate) {
        this.ratingDate = ratingDate;
    }

    public Integer getLocalAuthorityCode() {
        return localAuthorityCode;
    }

    public void setLocalAuthorityCode(Integer localAuthorityCode) {
        this.localAuthorityCode = localAuthorityCode;
    }

    public String getLocalAuthorityName() {
        return localAuthorityName;
    }

    public void setLocalAuthorityName(String localAuthorityName) {
        this.localAuthorityName = localAuthorityName;
    }

    public String getLocalAuthorityWebSite() {
        return localAuthorityWebSite;
    }

    public void setLocalAuthorityWebSite(String localAuthorityWebSite) {
        this.localAuthorityWebSite = localAuthorityWebSite;
    }

    public String getLocalAuthorityEmailAddress() {
        return localAuthorityEmailAddress;
    }

    public void setLocalAuthorityEmailAddress(String localAuthorityEmailAddress) {
        this.localAuthorityEmailAddress = localAuthorityEmailAddress;
    }

    public String getSchemeType() {
        return schemeType;
    }

    public void setSchemeType(String schemeType) {
        this.schemeType = schemeType;
    }

    public Boolean getNewRatingPending() {
        return newRatingPending;
    }

    public void setNewRatingPending(Boolean newRatingPending) {
        this.newRatingPending = newRatingPending;
    }

    public Double getGeocodeLongitude() {
        return geocodeLongitude;
    }

    public void setGeocodeLongitude(Double geocodeLongitude) {
        this.geocodeLongitude = geocodeLongitude;
    }

    public Double getGeocodeLatitude() {
        return geocodeLatitude;
    }

    public void setGeocodeLatitude(Double geocodeLatitude) {
        this.geocodeLatitude = geocodeLatitude;
    }

    public Integer getScoresHygiene() {
        return scoresHygiene;
    }

    public void setScoresHygiene(Integer scoresHygiene) {
        this.scoresHygiene = scoresHygiene;
    }

    public Integer getScoresStructural() {
        return scoresStructural;
    }

    public void setScoresStructural(Integer scoresStructural) {
        this.scoresStructural = scoresStructural;
    }

    public Integer getScoresConfidenceInManagement() {
        return scoresConfidenceInManagement;
    }

    public void setScoresConfidenceInManagement(Integer scoresConfidenceInManagement) {
        this.scoresConfidenceInManagement = scoresConfidenceInManagement;
    }

    public String getAddressLine4() {
        return addressLine4;
    }

    public void setAddressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
    }

    public Integer getLocalAuthorityBusinessID() {
        return localAuthorityBusinessID;
    }

    public void setLocalAuthorityBusinessID(Integer localAuthorityBusinessID) {
        this.localAuthorityBusinessID = localAuthorityBusinessID;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}