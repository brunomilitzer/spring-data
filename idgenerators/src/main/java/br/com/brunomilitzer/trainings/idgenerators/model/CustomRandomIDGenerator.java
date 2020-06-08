package br.com.brunomilitzer.trainings.idgenerators.model;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Random;

public class CustomRandomIDGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(final SharedSessionContractImplementor implementor, final Object object) throws HibernateException {
        final Random random = new Random();

        return (long) random.nextInt(10000000);
    }
}
