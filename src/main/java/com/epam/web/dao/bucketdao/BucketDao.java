package com.epam.web.dao.bucketdao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.dao.AbstractDao;
import com.epam.web.dao.extractor.FieldExtractorFactory;
import com.epam.web.dao.mapper.RowMapperFactory;
import com.epam.web.entity.Bucket;

public class BucketDao extends AbstractDao<Bucket> {
    public BucketDao(ProxyConnection connection) {
        super(connection, RowMapperFactory.createMapper(Bucket.TABLE), FieldExtractorFactory.createFieldExtractor(Bucket.TABLE),Bucket.TABLE);
    }
}
