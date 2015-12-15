"""Hello World API implemented using Google Cloud Endpoints.

Defined here are the ProtoRPC messages needed to define Schemas for methods
as well as those methods defined in an API.
"""

import endpoints
from google.appengine.ext import ndb
from protorpc import messages
from protorpc import remote
from protorpc.message_types import VoidMessage

# TODO: Replace the following lines with client IDs obtained from the APIs
# Console or Cloud Console.
WEB_CLIENT_ID = '140298350420-qvbr5c50mmualf39mlmiv767sqjikg1p.apps.googleusercontent.com'


class Greeting(ndb.Model):
    message = ndb.StringProperty(required=True, indexed=False)


class GreetingMessage(messages.Message):
    """Greeting that stores a message."""
    message = messages.StringField(1)


MULTIPLY_METHOD_RESOURCE = endpoints.ResourceContainer(
    GreetingMessage,
    times=messages.IntegerField(2, variant=messages.Variant.INT32,
                                required=True))


@endpoints.api(name='shouter', version='v1', owner_name='dcifuen',
               allowed_client_ids=[WEB_CLIENT_ID,
                                   endpoints.API_EXPLORER_CLIENT_ID], )
class ShouterApi(remote.Service):
    """Shouter API v1."""

    @endpoints.method(GreetingMessage, GreetingMessage,
                      path='shouter', http_method='POST',
                      name='greeting.update')
    def greeting_update(self, request):
        greeting = Greeting.get_by_id(1)
        if not greeting:
            greeting = Greeting(id=1)
        greeting.message = request.message
        greeting.put()
        return GreetingMessage(message=request.message)

    @endpoints.method(VoidMessage, GreetingMessage,
                      path='shouter', http_method='GET',
                      name='greeting.get')
    def greeting_get(self, request):
        greeting = Greeting.get_by_id(1)
        if not greeting:
            raise endpoints.NotFoundException('Greeting not found')
        return GreetingMessage(message=greeting.message)


APPLICATION = endpoints.api_server([ShouterApi])
