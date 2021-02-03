package org.grobid.trainer;

import org.grobid.core.GrobidModel;
import org.grobid.core.jni.WapitiModel;
import org.grobid.core.GrobidModels;
import org.grobid.trainer.SegmentationTrainer;
import java.math.BigDecimal;

import java.io.File;

/**
 * User: zholudev
 * Date: 3/20/14
 */
public class WapitiTrainer implements GenericTrainer {

    public static final String WAPITI = "wapiti";

	// default training parameters (only exploited by Wapiti)
	protected double epsilon = 0.00001; // default size of the interval for stopping criterion
	protected int window = 20; // default similar to CRF++
    protected int nbMaxIterations = 2000; // by default maximum of training iterations
    protected String algorithm = "l-bfgs"; // algorithm to be used, values: l-bfgs (default), sgd-l1, bcd, rprop, rprop+, rprop-


    @Override
    public void train(File template, File trainingData, File outputModel, int numThreads, GrobidModel model) {
		System.out.println("\tepsilon: " + epsilon);
		System.out.println("\twindow: " + window);
        System.out.println("\tnb max iterations: " + nbMaxIterations);
		System.out.println("\tnb threads: " + numThreads);
		System.out.println("\talgorithm: " + algorithm);

        WapitiModel.train(template, trainingData, outputModel, "--nthread " + numThreads +
       		" --algo " + algorithm +
			" -e " + BigDecimal.valueOf(epsilon).toPlainString() +
			" -w " + window +
			" -i " + nbMaxIterations
        );
    }

    @Override
    public String getName() {
        return WAPITI;
    }
	
    @Override
    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }
	
    @Override
    public void setWindow(int window) {
        this.window = window;
    }
	
    @Override
    public double getEpsilon() {
        return epsilon;
    }
	
    @Override
    public int getWindow() {
        return window;
    }

    @Override
    public void setNbMaxIterations(int interations) {
        this.nbMaxIterations = interations;
    }

    @Override
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public int getNbMaxIterations() {
        return nbMaxIterations;
    }
}
