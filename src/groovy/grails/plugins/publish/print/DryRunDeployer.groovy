package grails.plugins.publish.print

import grails.plugins.publish.PluginDeployer

/**
 * Dummy implementation of {@link PluginDeployer} that simply echoes
 * to a target information about what files are being deployed. By
 * default, the target is stdout.
 */
class DryRunDeployer implements PluginDeployer {
    def output = System.out
    
    void deployPlugin(File pluginPackage, File pluginXmlFile, File pomFile, boolean isRelease) {
        output.withWriter { w ->
            w.withPrintWriter { out ->
                out.println "Deploying the plugin package ${pluginPackage.canonicalPath}"
                out.println "with plugin descriptor ${pluginXmlFile.canonicalPath}"
                out.println "and POM file ${pomFile.canonicalPath}"
                out.println()
                out.println "This is${ !isRelease ? ' not' : ''} a release version"
            }
        }
    }
}