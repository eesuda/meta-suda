LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

# Allows to avoid fetching, unpacking and patching, since our code is already cloned by repo
inherit externalsrc

SRCREV = "tele"

# Don't use Yocto kernel configuration system, we instead simply override do_configure
do_configure() {
}

EXTERNALSRC_pn-linux-suda = "${TOPDIR}/../../linux-suda"
EXTERNALSRC_BUILD_pn-linux-suda = "${TOPDIR}/../../linux-suda"

LINUX_VERSION ?= "4.4.13"
LINUX_VERSION_EXTENSION = "+"

PR = "r0"

COMPATIBLE_MACHINE = "tele"

do_kernel_configme() {
  echo "skip this option"
}
