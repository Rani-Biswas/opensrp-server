package org.ei.drishti.form.repository;

import org.ei.drishti.form.domain.FormSubmission;
import org.ektorp.ComplexKey;
import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;
import org.ektorp.support.GenerateView;
import org.ektorp.support.View;
import org.motechproject.dao.MotechBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Repository
public class AllFormSubmissions extends MotechBaseRepository<FormSubmission> {
    private static Logger logger = LoggerFactory
			.getLogger(AllFormSubmissions.class.toString());
    @Autowired
    protected AllFormSubmissions(@Qualifier("drishtiFormDatabaseConnector") CouchDbConnector db) {
        super(FormSubmission.class, db);
    }

    public boolean exists(String instanceId) {
        return findByInstanceId(instanceId) != null;
    }

    @GenerateView
    public FormSubmission findByInstanceId(String instanceId) {
        List<FormSubmission> submissions = queryView("by_instanceId", instanceId);
        if (submissions == null || submissions.isEmpty()) {
            return null;
        }
        return submissions.get(0);
    }

    @View(name = "formSubmission_by_server_version", map = "function(doc) { if (doc.type === 'FormSubmission') { emit([doc.serverVersion], null); } }")
    public List<FormSubmission> findByServerVersion(long serverVersion) {
        ComplexKey startKey = ComplexKey.of(serverVersion + 1);
        ComplexKey endKey = ComplexKey.of(Long.MAX_VALUE);
        return db.queryView(createQuery("formSubmission_by_server_version").startKey(startKey).endKey(endKey).includeDocs(true), FormSubmission.class);
    }

    public List<FormSubmission> allFormSubmissions(long serverVersion, Integer batchSize) {
        ComplexKey startKey = ComplexKey.of(serverVersion + 1);
        ComplexKey endKey = ComplexKey.of(Long.MAX_VALUE);
        ViewQuery query = createQuery("formSubmission_by_server_version")
                .startKey(startKey)
                .endKey(endKey)
                .includeDocs(true);

        if (batchSize != null) {
            query.limit(batchSize);
        }
        return db.queryView(query, FormSubmission.class);
    }

    @View(
            name = "formSubmission_by_anm_and_server_version",
            map = "function(doc) { if (doc.type === 'FormSubmission') { emit([doc.anmId, doc.serverVersion], null); } }")
    public List<FormSubmission> findByANMIDAndServerVersion(String anmId, long version, Integer batchSize) {
        ComplexKey startKey = ComplexKey.of(anmId, version + 1);
        ComplexKey endKey = ComplexKey.of(anmId, Long.MAX_VALUE);
        ViewQuery query = createQuery("formSubmission_by_anm_and_server_version")
                .startKey(startKey)
                .endKey(endKey)
                .includeDocs(true);
        if (batchSize != null) {
            query.limit(batchSize);
        }
        return db.queryView(query, FormSubmission.class);
    }
    
    @View(
            name = "formSubmission_by_village_and_server_version",
            map = "function(doc) { if (doc.type === 'FormSubmission') { for(id in doc.formInstance.form.fields){if(doc.formInstance.form.fields[id].name ==='village'){emit([doc.formInstance.form.fields[id].value, doc.serverVersion], null); }}} }")
    public List<FormSubmission> findByVillageAndServerVersion(String village, long version, Integer batchSize) {
        ComplexKey startKey = ComplexKey.of(village, version + 1);
        ComplexKey endKey = ComplexKey.of(village, Long.MAX_VALUE);
        ViewQuery query = createQuery("formSubmission_by_village_and_server_version")
                .startKey(startKey)
                .endKey(endKey)
                .includeDocs(true);
        if (batchSize != null) {
            query.limit(batchSize);
        }
        logger.info("********** query***"+query);
        return db.queryView(query, FormSubmission.class);
      
    }
    
   @View (
            name = "by_id",
            map = "function(doc) { if(doc.entityId ) {emit(doc.entityId,[doc.formName,doc.formInstance,doc.anmId,doc.serverVersion])} }")
    public List<FormSubmission> findbyId() {
        return db.queryView(createQuery("by_id")
                .includeDocs(true),
                FormSubmission.class);
   }
    
    @View(
           name = "all",
            map = "function(doc) { if(doc.type === 'FormSubmission') {emit(doc.instanceId, doc._id)} }")
    public List<FormSubmission> findall() {
        return db.queryView(createQuery("all")
                .includeDocs(true),
                FormSubmission.class);
   }
    
   @View(
        name = "by_EntityId",
          map = "function(doc) { if(doc.entityId ) {emit(doc.entityId,[doc.formName,doc.formInstance,doc.anmId,doc.serverVersion])} }")
    public List<FormSubmission> findbyEntity() {
        return db.queryView(createQuery("by_EntityId")
                .includeDocs(true),
                FormSubmission.class);
    }
      
    @View(
            name = "by_instanceId",
            map = "function(doc) { if(doc.type === 'FormSubmission' && doc.instanceId) {emit(doc.instanceId, doc._id)} }")
    public List<FormSubmission> findbyInstanceId() {
        return db.queryView(createQuery("by_instanceId")
                .includeDocs(true),
                FormSubmission.class);
    }
    
    @View(
            name = "by_EntityId1",
            map = "function(doc) {if(doc.entityId) {emit(doc.entityId,[doc.serverVersion,doc.formName])} }")
    public List<FormSubmission> findbyentityId1() {
        return db.queryView(createQuery("by_EntityId1")
                .includeDocs(true),
                FormSubmission.class);
    }
   
    @View(
            name = "by_regId",
            map = "function(doc) { for(id in doc.formInstance.form.fields){ if(doc.formInstance.form.fields[id].name ==='regId'){if(doc.formInstance.form.fields[id].value){emit(doc.entityId,[doc.formName,doc.formInstance,doc.anmId,doc.serverVersion])} }}}")
    public List<FormSubmission> findbyregId() {
        return db.queryView(createQuery("by_regId")
                .includeDocs(true),
                FormSubmission.class);
    }
   
    @View(
            name = "checkEdit",
            map = "function(doc){if((doc.formName==='anc_reg_edit' ||doc.formName==='pnc_reg_edit'||doc.formName==='child_reg_edit') && doc.entityId){emit(doc.entityId,[doc.formName,doc.formInstance])}}")
    public List<FormSubmission> findcheckEdit() {
        return db.queryView(createQuery("checkEdit")
                .includeDocs(true),
                FormSubmission.class);
        
   }
}
