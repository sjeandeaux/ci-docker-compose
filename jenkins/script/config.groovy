import jenkins.*;
import jenkins.model.*;
import hudson.*;
import hudson.model.*;



def createCredential = { id, description, username, password ->
	domain = com.cloudbees.plugins.credentials.domains.Domain.global()
	credsStore = Jenkins.instance.getExtensionList("com.cloudbees.plugins.credentials.SystemCredentialsProvider")[0].getStore()
	newSecret = new com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl(
		com.cloudbees.plugins.credentials.CredentialsScope.GLOBAL,
		id,
		description,
		username,
		password
	)
	credsStore.addCredentials(domain, newSecret)
}

nexusReleases = "nexus-releases"
createCredential(nexusReleases, nexusReleases, "admin", "admin123")
nexusSnapshots = "nexus-snapshots"
createCredential(nexusSnapshots, nexusSnapshots, "admin", "admin123")


settingsFileProvider = org.jenkinsci.lib.configprovider.ConfigProvider
	.getByIdOrNull(org.jenkinsci.plugins.configfiles.maven.MavenSettingsConfig.class.getName())

settingsConfigId = "maven-settings"
settingsConfig = settingsFileProvider.getConfigById(settingsConfigId)

settingsConfigTemplate = settingsFileProvider.newConfig()
settingsConfigNew = new org.jenkinsci.plugins.configfiles.maven.MavenSettingsConfig(
	settingsConfigId,
	"maven settings.xml",
	"",
	new File("/tmp/maven-settings.xml").text,
	true, [new org.jenkinsci.plugins.configfiles.maven.security.ServerCredentialMapping("nexus-releases",nexusReleases),
         new org.jenkinsci.plugins.configfiles.maven.security.ServerCredentialMapping("nexus-snapshots", nexusSnapshots)]
)

settingsFileProvider.save(settingsConfigNew)
