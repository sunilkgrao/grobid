package org.grobid.trainer;

import org.grobid.core.GrobidModel;
import org.grobid.core.GrobidModels;
import java.io.File;

/**
 * User: zholudev
 * Date: 3/20/14
 */
public interface GenericTrainer {
    void train(File template, File trainingData, File outputModel, int numThreads, GrobidModel model);
    String getName();
	void setEpsilon(double epsilon);
	void setWindow(int window);
	double getEpsilon();
	int getWindow();
	int getNbMaxIterations();
	void setNbMaxIterations(int iterations);
    void setAlgorithm(String algorithm);
}
