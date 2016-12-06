package com.quancheng.saluki.monitor;

import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.Sets;

public class SalukiAppDependcy {

    private String                     appName;

    private Set<String>                dependcyApps;

    private Set<SalukiServiceDependcy> dependcyServices;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Set<String> getDependcyApps() {
        return dependcyApps;
    }

    public void setDependcyApps(Set<String> dependcyApps) {
        this.dependcyApps = dependcyApps;
    }

    public void addDependcyApp(String dependcyApp) {
        if (this.dependcyApps == null) {
            this.dependcyApps = Sets.newHashSet();
        }
        this.dependcyApps.add(dependcyApp);
    }

    public Set<SalukiServiceDependcy> getDependcyServices() {
        return dependcyServices;
    }

    public void setDependcyServices(Set<SalukiServiceDependcy> dependcyServices) {
        this.dependcyServices = dependcyServices;
    }

    public void addDependcyService(Set<Pair<String, Integer>> serviceCallCounts) {
        if (this.dependcyServices == null) {
            this.dependcyServices = Sets.newHashSet();
        }
        for (Pair<String, Integer> serviceCallCount : serviceCallCounts) {
            this.dependcyServices.add(new SalukiServiceDependcy(serviceCallCount.getLeft(),
                                                                serviceCallCount.getRight()));
        }

    }

    public static class SalukiServiceDependcy {

        private String  serviceName;

        private Integer callCount;

        public SalukiServiceDependcy(String serviceName, Integer callCount){
            this.serviceName = serviceName;
            this.callCount = callCount;
        }

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        public Integer getCallCount() {
            return callCount;
        }

        public void setCallCount(Integer callCount) {
            this.callCount = callCount;
        }

    }

}
