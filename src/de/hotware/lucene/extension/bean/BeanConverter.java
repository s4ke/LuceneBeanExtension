package de.hotware.lucene.extension.bean;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;

/**
 * A Bean converter can convert Beans that are annotated with BeanFields into
 * Lucene Documents
 * 
 * @author Martin Braun
 */
public interface BeanConverter {

	public <T> T documentToBean(Class<T> clazz, Document document);

	public Document beanToDocument(Object bean);

	public Analyzer getAnalyzer(Class<?> clazz, String locale);

}
