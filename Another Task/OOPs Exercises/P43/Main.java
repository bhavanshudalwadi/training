package P43;

import org.jocl.*;

public class Main {
    public static void main(String[] args) {
        // Enable exceptions and omit all logs
        CL.setExceptionsEnabled(true);
        CL.setLogLevel(CL.CL_LOG_NONE);

        // Size of the vectors
        int n = 1024;

        // Input vectors
        float[] a = new float[n];
        float[] b = new float[n];

        for (int i = 0; i < n; i++) {
            a[i] = i;
            b[i] = i * 2;
        }

        // Output vector
        float[] result = new float[n];

        // Initialize OpenCL
        CL.clInit();

        // Create the OpenCL context
        CLContext context = CLContext.create();

        // Create the OpenCL command queue
        CLCommandQueue queue = context.createDefaultQueue();

        // Allocate OpenCL memory objects
        CLBuffer<Float> clBufferA = context.createBuffer(CLMem.Usage.Input, FloatBuffer.wrap(a));
        CLBuffer<Float> clBufferB = context.createBuffer(CLMem.Usage.Input, FloatBuffer.wrap(b));
        CLBuffer<Float> clBufferResult = context.createBuffer(CLMem.Usage.Output, FloatBuffer.wrap(result));

        // Read the program source
        String source = "__kernel void vectorAdd(__global const float *a, __global const float *b, __global float *result) {" +
                "    int gid = get_global_id(0);" +
                "    result[gid] = a[gid] + b[gid];" +
                "}";

        // Create the OpenCL program
        CLProgram program = context.createProgram(source);

        // Build the program
        program.build();

        // Create the OpenCL kernel
        CLKernel kernel = program.createKernel("vectorAdd");

        // Set the arguments for the kernel
        kernel.setArgs(clBufferA, clBufferB, clBufferResult);

        // Execute the kernel
        CLNDRange globalWorkSize = new CLNDRange(n);
        queue.putWriteBuffer(clBufferA, false)
                .putWriteBuffer(clBufferB, false)
                .put1DRangeKernel(kernel, 0, globalWorkSize, null)
                .putReadBuffer(clBufferResult, true);

        // Display the result
        System.out.println("Result: " + Arrays.toString(result));

        // Clean up resources
        context.release();
    }
}