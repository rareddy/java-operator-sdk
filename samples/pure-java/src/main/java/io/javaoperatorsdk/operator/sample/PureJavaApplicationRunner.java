package io.javaoperatorsdk.operator.sample;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.javaoperatorsdk.operator.DefaultOperator;
import io.javaoperatorsdk.operator.Operator;
import io.javaoperatorsdk.operator.config.runtime.DefaultConfigurationService;

public class PureJavaApplicationRunner {

  public static void main(String[] args) {
    KubernetesClient client = new DefaultKubernetesClient();
    Operator operator = new DefaultOperator(client, DefaultConfigurationService.instance());
    operator.registerController(new CustomServiceController(client));
  }
}
