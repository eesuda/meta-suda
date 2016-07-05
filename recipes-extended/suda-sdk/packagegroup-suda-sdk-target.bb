SUMMARY = "Target packages for suda SDK"

PR = "r0"

LICENSE = "MIT"

# Qt4 could NOT be built on MIPS64 with 64 bits userspace
COMPATIBLE_HOST_mips64 = "mips64.*-linux-gnun32"

inherit packagegroup

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

RDEPENDS_${PN} += " \
        qwt-e-dev \
        "
