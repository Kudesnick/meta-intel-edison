SUMMARY = "Interactive process viewer"
HOMEPAGE = "http://github.com/htop-dev/htop"
SECTION = "console/utils"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=c312653532e8e669f30e5ec8bdc23be3"

DEPENDS = "ncurses"

SRCREV = "04cc193e3c0c39ea47eb01d61a6866b32d70baea"

SRC_URI = "git://github.com/htop-dev/htop.git \
           file://0001-Use-pkg-config.patch"
#SRC_URI[md5sum] = "7edaf501e9d117b2acad49bebde9be03"
#SRC_URI[sha256sum] = "fb23275090ee5fb19266384c39c69519c8b3844b8f6444730094949c621197c0"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

PACKAGECONFIG ??= "proc \
                   cgroup \
                   taskstats \
                   unicode \
                   linux-affinity \
                   delayacct"
PACKAGECONFIG[proc] = "--enable-proc,--disable-proc"
PACKAGECONFIG[openvz] = "--enable-openvz,--disable-openvz"
PACKAGECONFIG[cgroup] = "--enable-cgroup,--disable-cgroup"
PACKAGECONFIG[vserver] = "--enable-vserver,--disable-vserver"
PACKAGECONFIG[taskstats] = "--enable-taskstats,--disable-taskstats"
PACKAGECONFIG[unicode] = "--enable-unicode,--disable-unicode"
PACKAGECONFIG[linux-affinity] = "--enable-linux-affinity,--disable-linux-affinity"
PACKAGECONFIG[hwloc] = "--enable-hwloc,--disable-hwloc,hwloc"
PACKAGECONFIG[setuid] = "--enable-setuid,--disable-setuid"
PACKAGECONFIG[delayacct] = "--enable-delayacct,--disable-delayacct,libnl"

do_configure_prepend () {
    rm -rf ${S}/config.h
}
