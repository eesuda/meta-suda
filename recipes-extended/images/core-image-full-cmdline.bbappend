inherit extrausers
EXTRA_USERS_PARAMS = "\
    useradd -P tele tele; \
    usermod -aG sudo tele; \
    "
