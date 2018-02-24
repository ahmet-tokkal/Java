import java.io.BufferedWriter;
import java.io.FileWriter;

import php.java.bridge.http.JavaBridgeRunner;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils.DataSource;

public class WekaWithPhp 
{
	public static final String JAVABRIDGE_PORT="8087";
	  static final JavaBridgeRunner runner = JavaBridgeRunner.getInstance(JAVABRIDGE_PORT);

	  public static void main(String args[]) throws Exception {
	    runner.waitFor();
	    System.exit(0);
	  }
	public static String Test() 
	{
		return "Test is successful!";
	}
	public static  String ReadModel(String modelPath,String testPath, String savePath)
	{
		try {
			Classifier cls = (Classifier) SerializationHelper.read(modelPath);
            
            Instances test = null; 
            DataSource source2 = new DataSource(testPath);
            test = source2.getDataSet();
            test.setClassIndex(test.numAttributes()-1);
            Instances labeled = new Instances(test);
            String result = "-1";
            for (int i = 0; i < test.numInstances(); i++) 
            {
            	double clsLabel = cls.classifyInstance(test.instance(i));
            	labeled.instance(i).setClassValue(clsLabel);
            	result = test.classAttribute().value((int) clsLabel);
			}
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(savePath));
			writer.write(labeled.toString());
			writer.newLine();
			writer.flush();
			writer.close();
			return result;
		} catch (Exception e) {
			System.out.println(e);
			return "-1";
		}
	}
	public static String GetStatistics(String trainPath, String testPath,int info)
	{
		try {
            Instances train = null; 
            DataSource source2 = new DataSource(trainPath);
            train = source2.getDataSet();
            train.setClassIndex(train.numAttributes()-1);
            
            Instances test = null; 
            DataSource source = new DataSource(testPath);
            test = source2.getDataSet();
            test.setClassIndex(test.numAttributes()-1);
            
            Classifier cls = new NaiveBayes();
            cls.buildClassifier(train);
			Evaluation eval = new Evaluation(train);
			eval.evaluateModel(cls, test);
			//System.out.println(eval.toSummaryString("\nResults\n======\n", false));
			//System.out.println(eval.toMatrixString());
			if(info==0)
			{
				return eval.toSummaryString("\nResults\n======\n", false);
			}
			else if(info==1)
			{
				return eval.toMatrixString();
			}
			else
				return null;
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			return null;
		}	
	}
}
