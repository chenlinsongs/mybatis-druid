package com.thorough.mybatis.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thorough.mybatis.persistence.Page;
import com.thorough.mybatis.persistence.Pageable;
import com.thorough.mybatis.persistence.model.entity.IdUserDateDelFlagRemarksNameEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;
import java.util.List;

@Table(name = "pathology_image")
public class Image extends IdUserDateDelFlagRemarksNameEntity<String> implements Cloneable,Pageable<Image> {

    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "disease_id")
    private String diseaseId;

    @Column(name = "path")
    private String path;

    @Column(name = "describes")
    private String describes;

    @Column(name = "first_stamp_date")
    private Date firstStampDate;

    @Column(name = "modify_number")
    private Integer modifyNumber;

    @Column(name = "label_status")
    private Integer labelStatus;

    @Column(name = "review_status_doctor")
    private Integer reviewStatusDoctor;

    @Column(name = "review_status_expert")
    private Integer reviewStatusExpert;

    @Column(name = "review_status_adviser")
    private Integer reviewStatusAdviser;

    @Column(name = "review_status")
    private Integer reviewStatus;

    @Column(name = "review_stage")
    private Integer reviewStage;
    /*
    * 是否疑难切片
    * */
    @Column(name = "difficult")
    private Integer difficult;

    @Column(name = "allocation")
    private Integer allocation;

    @Column(name = "ai_predict")
    private Integer aiPredict;

    @Column(name = "type")
    private Byte type;

    @Column(name = "typical")
    private Integer typical;

    @Column(name = "submit_date")
    private Date submitDate;

    @Column(name = "hospital_id")
    private String hospitalId;

    @Column(name = "department_id")
    private String departmentId;

    @Column(name = "progress")
    private Integer progress;

    private boolean isReadable;

    private String userName;

    private String userId;

    private Byte ownership;

    /*
    * 最初分配切片时的状态
    * */
    private Integer initialReviewStage;

    private Integer favorites;

    /*
    * 是否个人疑难切片
    * */
    private Integer privateDifficult;

    /*
    * 个人疑难切片描述
    * */
    private String difficultDescribes;

    /*
    * 个人喜好描述
    * */
    private String favoritesDescribes;

    /*
    * 退回描述
    * */
    private String rollbackDescribes;

    private Integer statisticsType;

    private Integer rollback;

    @JsonIgnore
    @XmlTransient
    private Integer labelStatusRollback;

    @JsonIgnore
    @XmlTransient
    protected String imageUserDelFlag = "0";

    @JsonIgnore
    @XmlTransient
    @Column(name = "typical_describes")
    private String typicalDescribes;

    @JsonIgnore
    @XmlTransient
    protected Date createEndDate;

    @JsonIgnore
    @XmlTransient
    protected Date submitEndDate;

    @JsonIgnore
    @XmlTransient
    protected Date updateEndDate;

    @JsonIgnore
    @XmlTransient
    protected Date imageUserUpdateStartDate;

    @JsonIgnore
    @XmlTransient
    protected Date imageUserUpdateEndDate;


    @JsonIgnore
    @XmlTransient
    private String orderName;

    @JsonIgnore
    @XmlTransient
    private String order;

    @JsonIgnore
    @XmlTransient
    private String hospitalName;

    @JsonIgnore
    @XmlTransient
    private String departmentName;

    @JsonIgnore
    @XmlTransient
    private List<String> diseaseIdList;

    @JsonIgnore
    @XmlTransient
    private List<String> userIdList;

    @JsonIgnore
    @XmlTransient
    protected Integer actionType;

    @JsonIgnore
    @XmlTransient
    protected  String operation;

    @JsonIgnore
    @XmlTransient
    protected  String diseaseName;

    /*
   * 创建imageUser数据的时间
   * */
    @JsonIgnore
    @XmlTransient
    @Temporal(TemporalType.DATE)
    protected Date iucDate;

    /*
   * 更新imageUser数据的时间
   * */
    @JsonIgnore
    @XmlTransient
    @Temporal(TemporalType.DATE)
    protected Date iuuDate;
    /*
    * 更新imageUser表的人id
    * */
    @JsonIgnore
    @XmlTransient
    protected  String iuuBy;
    /*
    * 更新imageUser表的人
    * */
    @JsonIgnore
    @XmlTransient
    protected  String iuuName;

    @JsonIgnore
    @XmlTransient
    private Page<Image> page;

    public Image(){
        super();
    }

    public Image(String id) {
        super(id);
    }


    @Override
    public void preInsert() {
        super.preInsert();
        if (this.labelStatus == null)
            this.labelStatus = 0;
        if (this.modifyNumber == null)
            this.modifyNumber = 0;
        if (this.reviewStatus == null)
            this.reviewStatus = 0;
        if (this.reviewStatusAdviser == null)
            this.reviewStatusAdviser = 0;
        if (this.reviewStatusDoctor == null)
            this.reviewStatusDoctor = 0;
        if (this.reviewStatusExpert == null)
            this.reviewStatusExpert = 0;
        if (this.reviewStage == null)
            this.reviewStage = 10;
        if (this.difficult == null)
            this.difficult = 0;
        if (this.allocation == null)
            this.allocation = 0;
        if (this.aiPredict == null)
            this.aiPredict = 0;
        if (this.type == null)
            this.type = 0;
        if (this.ownership == null)
            this.ownership = 0;
        if (this.rollback == null)
            this.rollback = 0;
        if (progress == null)
            this.progress = 0;

    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes == null ? null : describes.trim();
    }

    public Date getFirstStampDate() {
        return firstStampDate;
    }

    public void setFirstStampDate(Date firstStampDate) {
        this.firstStampDate = firstStampDate;
    }

    public Integer getModifyNumber() {
        return modifyNumber;
    }

    public void setModifyNumber(Integer modifyNumber) {
        this.modifyNumber = modifyNumber;
    }

    public Integer getLabelStatus() {
        return labelStatus;
    }

    public void setLabelStatus(Integer labelStatus) {
        this.labelStatus = labelStatus;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(Integer reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Date getCreateEndDate() {
        return createEndDate;
    }

    public void setCreateEndDate(Date createEndDate) {
        this.createEndDate = createEndDate;
    }

    public Date getSubmitEndDate() {
        return submitEndDate;
    }

    public void setSubmitEndDate(Date submitEndDate) {
        this.submitEndDate = submitEndDate;
    }

    public Date getUpdateEndDate() {
        return updateEndDate;
    }

    public void setUpdateEndDate(Date updateEndDate) {
        this.updateEndDate = updateEndDate;
    }

    public String getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(String diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getReviewStatusExpert() {
        return reviewStatusExpert;
    }

    public void setReviewStatusExpert(Integer reviewStatusExpert) {
        this.reviewStatusExpert = reviewStatusExpert;
    }

    public Integer getReviewStatusAdviser() {
        return reviewStatusAdviser;
    }

    public void setReviewStatusAdviser(Integer reviewStatusAdviser) {
        this.reviewStatusAdviser = reviewStatusAdviser;
    }

    public Integer getReviewStatusDoctor() {
        return reviewStatusDoctor;
    }

    public void setReviewStatusDoctor(Integer reviewStatusDoctor) {
        this.reviewStatusDoctor = reviewStatusDoctor;
    }

    public Integer getDifficult() {
        return difficult;
    }

    public void setDifficult(Integer difficult) {
        this.difficult = difficult;
    }

    public Integer getAllocation() {
        return allocation;
    }

    public void setAllocation(Integer allocation) {
        this.allocation = allocation;
    }

    public Integer getAiPredict() {
        return aiPredict;
    }

    public void setAiPredict(Integer aiPredict) {
        this.aiPredict = aiPredict;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getOwnership() {
        return ownership;
    }

    public void setOwnership(Byte ownership) {
        this.ownership = ownership;
    }

    public List<String> getDiseaseIdList() {
        return diseaseIdList;
    }

    public void setDiseaseIdList(List<String> diseaseIdList) {
        this.diseaseIdList = diseaseIdList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<String> userIdList) {
        this.userIdList = userIdList;
    }

    public Integer getActionType() {
        return actionType;
    }

    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }

    public Integer getReviewStage() {
        return reviewStage;
    }

    public void setReviewStage(Integer reviewStage) {
        this.reviewStage = reviewStage;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getTypical() {
        return typical;
    }

    public void setTypical(Integer typical) {
        this.typical = typical;
    }

    public Integer getInitialReviewStage() {
        return initialReviewStage;
    }

    public void setInitialReviewStage(Integer initialReviewStage) {
        this.initialReviewStage = initialReviewStage;
    }

    public String getTypicalDescribes() {
        return typicalDescribes;
    }

    public void setTypicalDescribes(String typicalDescribes) {
        this.typicalDescribes = typicalDescribes;
    }

    public String getDifficultDescribes() {
        return difficultDescribes;
    }

    public void setDifficultDescribes(String difficultDescribes) {
        this.difficultDescribes = difficultDescribes;
    }

    public String getFavoritesDescribes() {
        return favoritesDescribes;
    }

    public void setFavoritesDescribes(String favoritesDescribes) {
        this.favoritesDescribes = favoritesDescribes;
    }

    public Integer getFavorites() {
        return favorites;
    }

    public void setFavorites(Integer favorites) {
        this.favorites = favorites;
    }

    public Integer getPrivateDifficult() {
        return privateDifficult;
    }

    public void setPrivateDifficult(Integer privateDifficult) {
        this.privateDifficult = privateDifficult;
    }

    public Integer getStatisticsType() {
        return statisticsType;
    }

    public void setStatisticsType(Integer statisticsType) {
        this.statisticsType = statisticsType;
    }

    public String getImageUserDelFlag() {
        return imageUserDelFlag;
    }

    public Integer getRollback() {
        return rollback;
    }

    public void setRollback(Integer rollback) {
        this.rollback = rollback;
    }

    public void setImageUserDelFlag(String imageUserDelFlag) {
        this.imageUserDelFlag = imageUserDelFlag;
    }

    public Integer getLabelStatusRollback() {
        return labelStatusRollback;
    }

    public void setLabelStatusRollback(Integer labelStatusRollback) {
        this.labelStatusRollback = labelStatusRollback;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public Date getIucDate() {
        return iucDate;
    }

    public void setIucDate(Date iucDate) {
        this.iucDate = iucDate;
    }

    public Date getIuuDate() {
        return iuuDate;
    }

    public void setIuuDate(Date iuuDate) {
        this.iuuDate = iuuDate;
    }

    public String getIuuBy() {
        return iuuBy;
    }

    public void setIuuBy(String iuuBy) {
        this.iuuBy = iuuBy;
    }

    public String getIuuName() {
        return iuuName;
    }

    public void setIuuName(String iuuName) {
        this.iuuName = iuuName;
    }

    public String getRollbackDescribes() {
        return rollbackDescribes;
    }

    public void setRollbackDescribes(String rollbackDescribes) {
        this.rollbackDescribes = rollbackDescribes;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public boolean isReadable() {
        return isReadable;
    }

    public void setReadable(boolean readable) {
        isReadable = readable;
    }

    public Date getImageUserUpdateStartDate() {
        return imageUserUpdateStartDate;
    }

    public void setImageUserUpdateStartDate(Date imageUserUpdateStartDate) {
        this.imageUserUpdateStartDate = imageUserUpdateStartDate;
    }

    public Date getImageUserUpdateEndDate() {
        return imageUserUpdateEndDate;
    }

    public void setImageUserUpdateEndDate(Date imageUserUpdateEndDate) {
        this.imageUserUpdateEndDate = imageUserUpdateEndDate;
    }

    public static String getFieldHospitalId(){
        return "hospitalId";
    }

    public static String getFieldAllocation(){
        return "allocation";
    }

    public static String getFieldDiseaseId(){
        return "diseaseId";
    }

    public static String getFiedTypical(){
        return "typical";
    }

    public static String getFiedReviewStage(){
        return "reviewStage";
    }

    public static String getFiedDifficult(){
        return "difficult";
    }

    public Image clone(){
        Image o = null;
        try{
             o = (Image) super.clone();
        }catch(CloneNotSupportedException e){
             e.printStackTrace();
        }
        return o;
    }

    @Override
    public Page<Image> getPage() {
        if (page == null){
            page = new Page<Image>();
        }
        return page;
    }

    @Override
    public Page<Image> setPage(Page<Image> page) {
        return null;
    }

}